# OOAD_Project 4.2

# Team Members : Shaily Goyal, Shreya Maitra

<h2>Java Version :17.0.6</h2>

<h2>Below is the updated UML daigram:</h2>

![Untitled Diagram-Page-1 drawio (3)](https://user-images.githubusercontent.com/111729856/225429424-d0b41c90-f2a4-47db-adce-9a1c6b219492.png)

[image 2 2 2 2.pdf](https://github.com/shaily29-eng/OOAD_Project4/files/10984449/image.2.2.2.2.pdf)




# UML Changes :
We have added new subclasses for Vehicles .The three new subclasses of vehicles introduced are ElectricTrucks, Formula1Cars and RacingMotorcycles. Also new classes have been created to implement the Command Pattern.

# Assumptions : 

We are starting the simulation considering that there are three types of staffs of each type Intern, Salerperson, Mechanic, Driver. 
Also we are considering that the inventory has 10 Vehicles of each type.The store vehicle stock also has 6 of each types of Cars i.e. Regular Cars, Pick Up Cars, Performance Cars, Electric Cars, Monster Trucks, Motorcycles. Also we are considering that one sales person can sell multiple cars. Also it is likely that one of each type of Mechanic, Salesperson, Intern can quit and Injured Drivers leave. Buyer can have only one addon. Now we have FNCD at two locations. We are assuming that both the locations share same store vehicle inventory and staff. The day starts with FNCD north opening followed by FNCD South opening. In this way all the other operations take place. Coming to the human interaction for buying a car on 31st day, we have assumed that the buyer will choose a car from the store vehicle innventory. The user has the option to not buy any add-on but the user needs to navigate to the buy add-on purchase option to complete the purchasing process. Rest functioning remain as-is.

# Test Cases :

The tescases are written in SimulationTestCases.java using junit libraries.

# Output of userinterface for buying a car :

Iteractive user actions from day 31 :

Below is the option to choose which FNCD location to purchase from:

![s1](https://user-images.githubusercontent.com/111729856/225433882-c387ba93-a7e5-4af6-89fc-c4d1e9a5eac8.png)

Below is the output when the user wants to know the salesperson's name:

![s2](https://user-images.githubusercontent.com/111729856/225433897-f97c1bd5-fa86-4836-b127-b9862e9aa403.png)

Below is the output when the user wants to change the salesperson's :

![s3](https://user-images.githubusercontent.com/111729856/225433916-03a78a1c-a849-469d-9ead-fc5082041440.png)

Below is the output when the user wants to know the current date time :

![s4](https://user-images.githubusercontent.com/111729856/225433934-ac94ea90-f8d3-4e89-a2b0-ba0562604e63.png)

Below is the output when the user wants to see the list of the cars to buy from:

![s5](https://user-images.githubusercontent.com/111729856/225433959-50fa53f7-8a6b-4337-9932-9cab631df3fd.png)

Below is the output with the car details which the user chooses which is 5 in this case:

![s6png](https://user-images.githubusercontent.com/111729856/225433987-67a8fb6d-5f84-4cf5-be23-aba75f628111.png)

Below is the output for buying any addons with the car:

![s7](https://user-images.githubusercontent.com/111729856/225433999-cd3404ad-f0b2-4fe9-851d-f2097792f27b.png)

Below is the final output on successful purchase:

![s8](https://user-images.githubusercontent.com/111729856/225434015-91141410-d654-491a-a7d1-4bd983b99ab3.png)


<h2>References:</h2>

<h3>https://www.w3schools.com/</h3>
<h3>https://www.geeksforgeeks.org/</h3>
<h3>https://www.tutorialspoint.com/</h3>
<h3>https://www.javatpoint.com/ </h3>
