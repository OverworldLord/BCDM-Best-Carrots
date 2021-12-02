# BCDM-Best-Carrots

The BCDM Best Carrots project implements the Bronco Centerpoint Dining Management system.

# How to Set up
## Java Application & Web Component
1. Our project is meant to be compiled through the use of [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers).
2. With the Eclipse IDE open, the project can be imported by right clicking on the Project Explorer, Selecting Import > Import > General > Existing Projects into workspace. From there, simply find and select the folder containing all of the project files from the location it has been saved to.
3. Below is a picture of our build path. jdk-17.0.1 and postgreSQL 14 are required to run the program.

## Database
1. If it is not already installed, download and install [pgAdmin 4](https://www.pgadmin.org/download/pgadmin-4-windows/) with the default username ('postgres') and the password '123'.
2. Create a database named 'cpp_restaurant'
3. Right click on the database 'cpp_restaurant' and select Backup. Import the file 113021.tar and press Backup.

If you have installed everything correctly, you should now be able to use our application without issue.

# Example Execution
[Click here to see an example execution of our program](https://youtu.be/UdjHaxs2bcU)

# Text Field Constraints
* Entries can't be empty; put N/A if not applicable.
* The format that should be given to date text fields is YYYY-MM-dd.
