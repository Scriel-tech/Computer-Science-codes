//Currently, the only problem is that I can't get it to output more than one error message

var myForm = document.forms.myForm;
var message = document.getElementById("message");
//So we get the form and the message div incase they have incorrectly filled the form



myForm.onsubmit = function(){
    var arr = [];//Contains the form details
    var name = myForm.name.value;
    var surname = myForm.surname.value;
    var age = myForm.age.value;
    var email = myForm.email.value;
    var password = myForm.password.value;
    var confirmPassword = myForm.confirmPassword.value;
    var errors = []; //Will put the errors here
    
    var final = ""
    if(name == "" || surname == "" || age == "" || email == "" || password == "" || confirmPassword == "" || password != confirmPassword)
    {
        if(name == ""){
            final += "Please put a name \n";
        }else if(surname == ""){
            final += "Please put a surname \n";
        }else if(age == ""){
            final += "Please put an age \n";
        }else if(email == ""){
            final += "Please put an email \n";
        }else if(password == ""){
            final += "Please put a password \n";
        }else if(confirmPassword == ""){
            message.innerHTML = "Please confirm your password \n";
        }else{
            alert("Passwords don't match");
        }
        message.innerHTML = final;
        console.log(final);
        return false;
    }else{
        message.innerHTML = "";
        arr[0] = name;  //Stores the values into the array because the form is correct
        arr[1] = surname;
        arr[2] = age;
        arr[3] = email;
        arr[4] = password;
        arr[5] = confirmPassword;
        
        alert("Success");
        return true;  
    }
};
