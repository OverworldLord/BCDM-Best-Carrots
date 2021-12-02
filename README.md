# BCDM-Best-Carrots

The BCDM Best Carrots project implements the Bronco Centerpoint Dining Management system.

# How to Set up
## Java Application & Web Component
1. Our project is meant to be compiled through the use of [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/indigo/sr2).
2. With the Eclipse IDE open, the project can be imported by right clicking on the Project Explorer, Selecting Import > Import > General > Existing Projects into workspace. From there, simply find and select the folder containing all of the project files from the location it has been saved to.
3. Please ensure that all of the required libraries are in the build path. This includes the JRE System Library, EAR Libraries, postgresql-42.2.24.jre7.jar, Web App Libraries, and Server Runtime Apache Tomcat v7.0.

## Database
1. If it is not already installed, download and install [pgAdmin 4](https://www.pgadmin.org/download/pgadmin-4-windows/) with the default username ('postgres') and the password '123'.
2. Create a database named 'cpp_restaurant'
3. Right click on the database 'cpp_restaurant' and select Backup. Import the file 113021.tar and press Backup.

## Apache Tomcat
To access the optional web component of the project, please install the desired version of [Apache Tomcat](https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.22/) and add the server to the project.

If you have installed everything correctly, you should now be able to use our application without issue.

# Example Execution
[Click here to see an example execution of our program](https://youtu.be/UdjHaxs2bcU)

# Text Field Constraints
* Entries can't be empty; put N/A if not applicable.
* The format that should be given to date text fields is YYYY-MM-dd.
