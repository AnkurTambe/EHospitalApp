# EHospitalApp
Android Studio

APIs|Fragments|CardView|LogIn|SignUp|WalkThrough|HomePage|SplashScreen|RecyclerView|GmailIntegration|

WAMP-- Windows, Apache, MySQL, PHP

4 types of logins- Admin, Doctor, Jr. Doctor, Human Resource

All the changes the Database are made by Admins(directly through in WAMP server through main Computer which hostung the localserver), and all the other login-types can request the any specific change in the DB through mailing the admins(mailing atleast one admin is sufficient). 

The GmailIntegration button is provided in the Profile Section. For Admins, GmailIntegration button will open their Gmail Inbox. For other login-types it open up the various mail-ids of the Admins, and on further clicking them it will open-up the the 'Compose' section where you can draft mail suggesting the changes in the DB(mailing atleast one admin is sufficient).

The mail should have proper information in proper format.

For SignUp too, you need to mail the Admin(mailing atleast one admin is sufficient).Changes in DB(normal/signups)- Admins will decide among them and administer the changes.

*APK is the Release section*

Screenshots of the App:

![img1](https://user-images.githubusercontent.com/76391639/123265395-a343e800-d518-11eb-80f2-096ada377e55.jpg)
![img2](https://user-images.githubusercontent.com/76391639/123265411-a7700580-d518-11eb-8b61-1b75fb0f2384.jpg)
![img3](https://user-images.githubusercontent.com/76391639/123265425-accd5000-d518-11eb-8daa-60fc399b773d.jpg)
![img4](https://user-images.githubusercontent.com/76391639/123265439-b060d700-d518-11eb-92ee-332d65739a9e.jpg)
![img5](https://user-images.githubusercontent.com/76391639/123265454-b3f45e00-d518-11eb-961a-5d32484bc51f.jpg)

The App is based on WAMP local server so, to see the full execution of the app you have to first do following things:
1. Download WAMP server and install it on your PC. Clone the repo.
2. Go to the file of WAMP(wamp64) and, then to the 'www' folder located inside it. Generally- C:\wamp64\www
3. Copy the folder 'EHospitalPhp' from the code section of this repo, and paste it in the 'www' folder. Now the PHP(APIs) setup is complete.
4. Find the 'ehospitaldb.sql' from code section of this repo.
5. Run the WAMP app then, go to a browser and type 'http://localhost/phpmyadmin/' in URL, and hit enter.
6. The phpmyadmin login page will appear, username is 'root' and password is blank i.e. nothing, select the server option as 'MySql', then hit 'Go'.
7. Phpmyadmin index page will appear, click on 'Import' and then click on 'Choose File' option, select the 'ehospitaldb.sql' and then hit 'Go'. Now the database setup is complete.
8. Overall Local Server is setup. Now, install the App from the APK. Ensure that WAMP server is running properly.
9. Now, in the right side of the taskbar, WAMP symbol will appear. Left click on it, then go to 'Apache' and then open 'httpd-vhost.conf'.
10. Replace 'Require Local' to 'Require all granted'. Restart the WAMP app.
11. Ensure the mobile, that has the app installed, and the PC, that has the local server setup, are connected to the same WIFI.
12. If you are opening the app for the first time on a specific mobile device, there will be a prompt asking you for the IPv4 Address of the WLAN connected to the WAMP server.
13. IPv4 Address of the WLAN can be obtained by using the command 'ipconfig' in the CMD.
14. The prompt will come on automatically after the splash screen. And you can manually call the prompt by using various 'Change IP' buttons present in the app.
15. Ensure you give proper IPv4 Address, otherwise the app will not be able to properly contact server and will give you error.
16. Now, you can launch the app, and see its execution.
