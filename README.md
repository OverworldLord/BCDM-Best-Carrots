# BCDM-Best-Carrots

The BCDM Best Carrots project implements the Bronco Centerpoint Dining Management system.

# How to Set up
## Java Application & Web Component
1. Our project is meant to be compiled through the use of [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/indigo/sr2).
2. With the Eclipse IDE open, the project can be imported by right clicking on the Project Explorer, Selecting Import > Import > General > Existing Projects into workspace. From there, simply find and select the folder containing all of the project files from the location it has been saved to.
3. Please ensure that all of the required libraries are in the build path. This includes the JRE System Library, EAR Libraries, postgresql-42.2.24.jre7.jar, Web App Libraries, and Server Runtime Apache Tomcat v9.0.
4. Please ensure that the project folder has Dynamic Web Module 3.0 and Java 1.8. It should already be pre-set to those settings, but if any errors occur, you can change the versions in the "Project facets". 
5. Please add the Java Project "BCDM-Best-Carrots" to the Tomcat9.0 server once you have created it.
6. To run the web component, navigate to "BCDM-Best-Carrots/main.webapp/RegScreen.jsp", right click the file, and click run on server. Make sure your Tomcat9.0 server is up and running.

## Database
1. If it is not already installed, download and install [pgAdmin 4](https://www.pgadmin.org/download/pgadmin-4-windows/) with the default username ('postgres') and the password '123'.
2. Create a database named 'cpp_restaurant'
3. Right click on the database 'cpp_restaurant' and select Backup. Import the file 113021.tar and press Backup.

## Apache Tomcat
To access the optional web component of the project, please install the desired version of [Apache Tomcat](https://tomcat.apache.org/download-90.cgi) and add the server to the project.

If you have installed everything correctly, you should now be able to use our application without issue.

# Example Execution
[Click here to see an example execution of our program](https://youtu.be/UdjHaxs2bcU)

# Text Field Constraints
* Entries can't be empty; put N/A if not applicable.
* The format that should be given to date text fields is YYYY-MM-dd.
