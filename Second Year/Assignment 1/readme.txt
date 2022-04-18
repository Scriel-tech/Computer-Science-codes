This project similuates the flow of water down a valley plain, it makes use of parallel computing and concurrency to simulate the flow of water.

To start the code, pass in the terrain data as an input file. This will create a GUI with buttons- Play,Pause,Start,End. Firstly add water to the screen by clicking on the terrain and then click play to start the simulation. The other buttons are as labelled. No the that the GUI is created within the setupGUI method. That is where the moseListener and buttons are located. The water class holds the details of water at a grid position, and is stored in its position in the waters array in FlowPanel class. The GUI consists of 2 images the terrain image and a land image above it. Both can be found in the Terrain class.

To run code you have to  be in the bin directory and type:

java Flow "../SampleData/SampleData/medsample_in.txt"

java Flow "../SampleData/SampleData/largesample_in.txt"
