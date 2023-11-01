# TaskA

Project Name
Task A
Getting Started
These are the steps to set up and run the project on your local machine.
Prerequisites
•	Visual Studio Code (for React)
•	Spring Tool Suite (STS) (for Spring Boot)
•	MySQL database with a database named "task_a"
Setup
1.	Clone the repository.
git clone https://github.com/udariDilsara/TaskA.git 
2.	Backend Setup (Spring Boot):
•	Import the "a" folder as a Spring Boot project in STS.
•	Make sure you have MySQL running locally.
•	Create a MySQL database named "task_a".
•	Configure the database connection in the application.properties file.
•	Run the AApplication.java file to start the Spring Boot backend.
•	Port : 8085
3.	Frontend Setup (React):
•	Open the "Afrontend" folder in Visual Studio Code.
•	In the terminal, navigate to the "Afrontend" directory.
•	Install the required dependencies.
bashCopy code
npm install 
•	Start the React application.
bashCopy code
npm start 
4.	Access the Application:
•	Open a web browser and go to http://localhost:3000 to access the home page of the application.
Usage
Adding Drones
1.	Navigate to the "Drone" section in the navigation bar.
2.	You can add drones to the database with the following information:
•	Code model  weight_limit
•	1 LIGHTWEIGHT 150
•	2 MIDDLEWEIGHT 200
•	3 CRUSEREWEIGHT 350
•	4 MIDDLEWEIGHT 500
3.	After adding drones, you can view them by clicking on the "Available Drone" button.
Loading Medication
1.	Go to the "LoadMedication" section in the navigation bar and click.
2.	You will see a list of medications populated with dummy data in the frontend application.
3.	Select one of them and click on the "Select drone" button.
4.	The application will select a suitable drone for your package based on weight comparisons.
5.	Click on the "Load" button to update the medication database.



