const { useState, useRef, useEffect } = React

//Redux
  //actions to increase or decrease the session or break times
const INCREMENTSESSION = "INCREMENTSESSION";
const DECREMENTSESSION = "DECREMENTSESSION"
const INCREMENTBREAK = "INCREMENTBREAK";
const DECREMENTBREAK = "DECREMENTBREAK";
const SETPLAY = "SETPLAY";
const SETPAUSE = "SETPAUSE";

  //Action creators
const incrementAction = () => {
  return {type: INCREMENTSESSION};
}

const decrementAction = () => {
  return {type: DECREMENTSESSION};
}

const incrementBreakAction = () =>{
  console.log("level 4")
  return {type: INCREMENTBREAK};
}

const decrementBreakAction = () => {
  return {type: DECREMENTBREAK};
}

const resetValues = () => {
  return {type: "RESET"};
}

const setPlay = () => {
  return {type: SETPLAY};
}

const setPause = () => {
  return {type: SETPAUSE};
}

const defaultState = {
  session: 25,
  break: 5
}

//TimerReducer
const timeReducer = (state = defaultState, action) => {
  switch(action.type){
    case "INCREMENTSESSION":
      state = state.session<60 ? {session: state.session + 1, break: state.break} : {session: state.session, break: state.break};
      return state;
      break;
    case "DECREMENTSESSION":
      state = state.session>1 ? {session: state.session - 1, break: state.break} : {session: state.session, break: state.break};
      return state;
      break;
    case "INCREMENTBREAK":
      state = state.break < 60 ? {session: state.session, break: state.break + 1} : {session: state.session, break: state.break}
      return state;
    case "DECREMENTBREAK":
      state = state.break > 1 ? {session: state.session, break: state.break - 1} : {session: state.session, break: state.break};
      return state;
    case "RESET":
      return defaultState;
    default:
      return state;
  }
}

//Pause Reducer
const pauseReducer = (state = {pause: true}, action) => {
  switch(action.type){
    case "SETPAUSE":
      return {pause: true};
    case "SETPLAY":
      return {pause: false};
    default:
      return state;
  }
}

const rootReducer = Redux.combineReducers({
  pause: pauseReducer,
  time: timeReducer
});

const store = Redux.createStore(rootReducer);

//React
const Provider = ReactRedux.Provider;
const connect = ReactRedux.connect;

class App extends React.Component{
  constructor(props){
    super(props);
  }
  
  render(){
    return(
      <div id="app-container" class="center">
        <h1 id="title">25 + 5 Clock</h1>
        <div id="timersettings-div">
          <TimerSettings name="Session Timer" Time={this.props.Session} increaseTime={this.props.increaseSession} decreaseTime={this.props.decreaseSession} ispaused={this.props.Pause} />
          <TimerSettings name="Break Timer" Time={this.props.Break} increaseTime={this.props.increaseBreak} decreaseTime={this.props.decreaseBreak} ispaused={this.props.Pause} />
        </div>
        <Timer Session={this.props.Session} Break={this.props.Break} Reset={this.props.resetValues} setPause={this.props.setPause} setPlay={this.props.setPlay}/>
      </div>
  );}  
}

class TimerSettings extends React.Component{
  //pass 2 values as props, that is the time's name and it's default starting value;
  
    constructor(props){
    super(props);
    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
  }
  
  handleIncrement(){
    console.log("In level 1")
    if(this.props.ispaused){
      console.log("In level 2")
      this.props.increaseTime();
      console.log("In Level 3")
      console.log(this.props.ispaused)
    }
  }
  
  handleDecrement(){
    //console.log(this.props.decreaseTime);
    if(this.props.ispaused){
      this.props.decreaseTime();
    }
  }

  render(){
    //The id's of the elements
    const id = this.props.name.split(" ")[0].toLowerCase() + "-label";
    const incrementid = this.props.name.split(" ")[0].toLowerCase() + "-increment";
    const decrementid = this.props.name.split(" ")[0].toLowerCase() + "-decrement";
    const lengthid = this.props.name.split(" ")[0].toLowerCase() + "-length";
    
    return(
      <div class="timer-box">
        <h5 id={id}>{this.props.name}</h5>
        <div class="timer-element-box">
          <button id={incrementid} onClick={this.handleIncrement} class="btn vtn-link"><i class="fas fa-arrow-up arrow"></i></button>
          <h3 id={lengthid}>{this.props.Time}</h3>
          <button id={decrementid} onClick={this.handleDecrement} class="btn vtn-link"><i class="fas fa-arrow-down arrow"></i></button>
        </div>
      </div>
    );
  }
}

function Timer(props){
  const [seconds, setSeconds] = useState(props.Session*60);
  const secondsRef = useRef(seconds);
  const [paused, setPaused] = useState(true);
  const pausedRef = useRef(paused);
  const [whichTime, setWhichTime] = useState("Session");
  const whichTimeRef= useRef(whichTime);
  let current = Object.assign(props.Session);
  const [icon, setIcon] = useState("fas fa-play");
  let name = "Play";
  
  function reset(){
    setPaused(true);
    /*if(whichTime == "Session"){
      setSeconds(props.Session*60);
    }else if(whichTime == "Break"){
      setSeconds(props.Break*60);
    }*/
    setSeconds(props.Session*60);
    setWhichTime("Session");
    setIcon("fas fa-play");
    props.Reset();
    //Reset the sound
    var sound = document.getElementById("beep");
    sound.pause();
    sound.currentTime = 0;
  }
  
  function playSound(id) {
    var sound = document.getElementById(id);
    sound.play();
  }
  
  useEffect(() => {
    if(!paused){
      if(current != props.Session){
        setSeconds(props.Session*60);
        setWhichTime("Session");
      }
      secondsRef.current = setInterval(() =>{
        setSeconds((t) => t-1)
      }, 1000);
    }else{
      clearInterval(secondsRef.current);
    }
    return () => clearInterval(secondsRef.current);
  }, [paused])
  
  useEffect(() =>{
    if(seconds <=0){
      //Trigger the beep here
      playSound("beep");
      if(whichTime == "Session"){
        setSeconds(props.Break*60);
        setWhichTime("Break");
      }else if(whichTime == "Break"){
        setSeconds(props.Session*60);
        setWhichTime("Session");
      }
    }
    
    if(seconds<=60){
      $("#time-left").css("color","red");
    }else{
      $("#time-left").css("color","black");
    }
  }, [seconds])
  
  useEffect(() => {
    if(paused){
      setSeconds(props.Session * 60);
    }
  }, [props.Session, props.Break])
  
  function handleClick(){
    if(!paused){
      setPaused(true);
      name = "Pause";
      setIcon("fas fa-play");
      props.setPause();
    }else{
      setPaused(false);
      name = "Play";
      setIcon("fas fa-pause");
      props.setPlay();
    }
  }
  return(
    <div>
      <div class="countdown">
        <h4 id="timer-label">{whichTime}</h4>
        <DisplayTime time={seconds} />
      </div>
      <div id="buttons">
        <button id="start_stop" onClick={() => handleClick()}><i class={icon}></i></button>
        <button id="reset" onClick={reset}><i class="fas fa-undo">           </i></button>
      </div>
    </div>
  )
}

function DisplayTime({time}){
  let min = Math.floor(time/ 60);
  let seconds = time % 60;
  seconds = seconds<10 ? "0"+seconds : seconds;
  min = min < 10 ? "0"+min : min;
  
  let color = "background: grey";
  color = min <1 ? "background: red": color;
  
  return <h2 id="time-left">{min}:{seconds}</h2>
}

//redux-react
const mapStateToProps = (state) => {
  return {
    Session: state.time.session,
    Break: state.time.break,
    Pause: state.pause.pause
  };
}

const mapDispatchToProps = (dispatch) => {
  return(
    {
      increaseSession: function(){
        dispatch(incrementAction());
      },
      decreaseSession: function(){
        dispatch(decrementAction());
      },
      increaseBreak: function(){
        dispatch(incrementBreakAction());
      },
      decreaseBreak: function(){
        dispatch(decrementBreakAction());
      },
      resetValues: function(){
        dispatch(resetValues());
        dispatch(setPause());
      },
      setPause: function(){
        dispatch(setPause());
      },
      setPlay: function(){
        dispatch(setPlay());
      }
    }
  );
}

const Container = connect(mapStateToProps, mapDispatchToProps)(App);


class AppWrapper extends React.Component {
  // Render the Provider below this line
  render(){
    return(
      <Provider store={store}>
        <Container />
      </Provider>
    )};
};

ReactDOM.render(<AppWrapper />, document.getElementById("main"));
