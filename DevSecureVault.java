// Save Username-Password Manager.
// Encode Data (For Security).
// Search Username-Password.
// also Store meta-data with if
// try to use Json.

// Save Username and Password
// Data Mustbe in Encrypted college
// Generate User Activity Logs
// USer can add Security Questions
// Add ,Date of creation, updated, deletion
// Stroe all Passwords like old and new
// See all Pass words history
// Test Passwors
// Add metadata reletade to it.
// Check Pass word Strength
// Direct Copy to clipboard
// Store images or screen shots related to it 
// Add Security
// Add Security Time
// Set attempts
// Get password Hints
// Get half password like: xyz***j32 
// Generate Password
// Overload GEnerate Password (customized... x) var-arg (passwords includes add thing which we need like: dev,2573 --> 123s2573gdfgdev@4)
// Vrify User
// Logout User


// If Extra Time available
// Save form Responses 
// Remove or Delete  User

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;

class DevSecureVault{
    String user_id;
    HashMap<String,String> user_info;
    HashMap<String,String> site_info;
    static File f = new File("./Data/Users/");
    int loginAttemptBolckTime = 30; // in Minutes


    DevSecureVault(){
        user_info = new HashMap<String,String>();
        site_info = new HashMap<String,String>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DevSecureVault main_obj = new DevSecureVault();
        // boolean loop_flag = true;


        System.out.print("\033[H\033[2J"); 
        System.out.flush();

        System.out.println("WELCOME TO...");
        System.out.println("+----------------------------------------------+");
        System.out.println("|                DevSecureVault                |");
        System.out.println("+---------------------------------By-Dev-Shah--+");
        do{
            
            System.out.println("|Menu|");
            System.out.println("+----------------------------------------------+");
            System.out.print("|1|Existing User\n|2|New User\n|3|Exit\n|Enter option: ");
            int user_selction ;
            try{
                user_selction = Integer.parseInt(sc.next());
                
            }
            catch(NumberFormatException e){
                user_selction = 4;
            }
            catch(Exception e){
                user_selction = 4;
            }
            System.out.println("+----------------------------------------------+");
            switch (user_selction) {
                case 1:// for Existing User
                    try{

                        System.out.println("||| User Login |||");
                        System.out.print("|Enter Email id:");
        
                        String login_email_id = sc.next();
                        // Check User Existance
                        boolean user_exist = main_obj.checkUserExists(login_email_id);
                        if(user_exist){
                            // get user details from database
                            main_obj.fetchUserInfo(login_email_id);

                            // Check if user blocked og 30 min or not due to finished attempts
                            if(!main_obj.blockUserLogin()){ 
                                System.out.print("|Enter Password:");
                                String login_password = sc.nextLine();
                                login_password = sc.nextLine();
    
                                if(main_obj.user_info.get(encrypt("login_password")).equals(encrypt(login_password))){
                                    main_obj.generateLoginLog(true);
                                    ///////////////////////////////////////////////
                                    // Now User Verified and Logged in Successfully.
                                    System.out.println("+----------------------------------------------+");
                                    System.out.println("|Welcome Back, "+decrypt(main_obj.user_info.get(encrypt("first_name"))));
                                    boolean user_logout = false;
                                    while (!user_logout) {
                                        System.out.println("+----------------------------------------------+");
                                        System.out.println("|Function Menu|");
                                        System.out.println("+----------------------------------------------+");
                                        System.out.println("| 1|Add New Site Details");
                                        System.out.println("| 2|Update Site Password");
                                        System.out.println("| 3|Remove Site ");
                                        System.out.println("| 4|View Added Site Names");
                                        System.out.println("| 5|View Site Details");
                                        System.out.println("| 6|View Only Password");
                                        System.out.println("| 7|View Hint Password");
                                        System.out.println("| 8|Get Hint About the Password");
                                        System.out.println("| 9|Check Password Strength");
                                        System.out.println("|10|Generate Random Password");
                                        System.out.println("|11|Generate Custom Password");
                                        System.out.println("|12|Log out");
                                        System.out.print("|Enter :");
                                        int select_function = 13;
                                        try{
                                            select_function = sc.nextInt();
                                            
                                        }
                                        catch(NumberFormatException e){
                                            sc.next();
                                            user_selction = 13;
                                        }
                                        catch(Exception e){
                                            sc.next();
                                            user_selction = 13;
                                        }
                                        System.out.println("+----------------------------------------------+");
                                        switch (select_function) {
                                            case 1:// Add New Site
                                                try{
                                                    System.out.println("||NOTE|| Enter 'NA' if Not Applicable or Data you enterd on Site/App during Signup.");
                                                    System.out.println("|");
                                                    System.out.print("|Enter Site/App Name (must be Unique): ");
                                                    String site_name = sc.nextLine();
                                                    site_name = sc.nextLine();

                                                    if(!main_obj.checkSiteExists(site_name)){

                                                        System.out.print("|Enter Site/App URL: ");
                                                        String site_url= sc.nextLine();
                                                        System.out.print("|Enter Login Id/Email: ");
                                                        String site_login_email= sc.nextLine();
                                                        System.out.print("|Enter Login Password: ");
                                                        String site_login_password= sc.nextLine();
                                                        System.out.print("|Enter Hint to recall it: ");
                                                        String site_password_hint= sc.nextLine();
                                                        System.out.print("|Enter Username: ");
                                                        String site_username= sc.nextLine();
                                                        System.out.print("|Enter User first name: ");
                                                        String site_user_first_name= sc.nextLine();
                                                        System.out.print("|Enter User gender: ");
                                                        String site_user_gender= sc.nextLine();
                                                        System.out.print("|Enter date of birth (DD/MM/YYYY): ");
                                                        String site_dob= sc.nextLine();
                                                        System.out.print("|Enter phone no.: ");
                                                        String site_phone= sc.nextLine();
                                                        System.out.print("|Enter Text or Note: ");
                                                        String site_note= sc.nextLine();
    
                                                        File siteFile = new File(main_obj.user_info.get(encrypt("userSitesDataFolder"))+"/"+encrypt(site_name)+".txt");
                                                        siteFile.createNewFile();
                                                        FileWriter siteFileWiter = new FileWriter(siteFile); 
    
                                                        // date of creation , password strength ,lastmodified
                                                        main_obj.site_info.put(encrypt("site_name"), encrypt(site_name));
                                                        main_obj.site_info.put(encrypt("site_url"), encrypt(site_url));
                                                        main_obj.site_info.put(encrypt("site_login_email"), encrypt(site_login_email));
                                                        main_obj.site_info.put(encrypt("site_login_password"), encrypt(site_login_password));
                                                        main_obj.site_info.put(encrypt("site_password_hint"), encrypt(site_password_hint));
                                                        main_obj.site_info.put(encrypt("site_username"), encrypt(site_username));
                                                        main_obj.site_info.put(encrypt("site_user_first_name"), encrypt(site_user_first_name));
                                                        main_obj.site_info.put(encrypt("site_user_gender"), encrypt(site_user_gender));
                                                        main_obj.site_info.put(encrypt("site_dob"), encrypt(site_dob));
                                                        main_obj.site_info.put(encrypt("site_phone"), encrypt(site_phone));
                                                        main_obj.site_info.put(encrypt("site_note"), encrypt(site_note));
                                                        main_obj.site_info.put(encrypt("site_creation"), encrypt(LocalDateTime.now().toString()));
                                                        main_obj.site_info.put(encrypt("site_last_modified"), encrypt(LocalDateTime.now().toString()));
                                                        main_obj.site_info.put(encrypt("site_login_password_strength"), encrypt(main_obj.getPasswordStrength(site_login_password)));
    
                                                        for(Map.Entry entry : main_obj.site_info.entrySet()){
                                                            siteFileWiter.write(entry.toString()+"\n");
                                                            siteFileWiter.flush();
                                                        }
                                                        siteFileWiter.close();
                                                        siteFile.setReadOnly();
                                                        System.out.println("||SUCCESS|| Site Details Added Successfully.");
                                                        // clear the hashmap of site info
                                                        // main_obj.site_info.clear();
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! This site name alredy Exists.");
                                                    }

                                                }
                                                catch(Exception e){
                                                    System.out.println("||EXCEPTION 1|| "+e.getMessage());
                                                }
                                                break;
                                            case 2:// Update Site Password
                                                try{
                                                    System.out.print("|Enter Site Name to Update Password:");
                                                    sc.nextLine();
                                                    String site_name = sc.nextLine();
                                                    if(main_obj.checkSiteExists(site_name)){
                                                        main_obj.updateSitePassword(site_name);
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
                                                    }
                                                    
                                                }
                                                catch(Exception e){
                                                    System.out.println("||EXCEPTION 2|| "+e.getMessage());
                                                }
                                                break;
                                            case 3:// Remove Site
                                                try{
                                                    System.out.print("|Enter Site Name to View Details:");
                                                    sc.nextLine();
                                                    String site_name = sc.nextLine();
                                                    if(main_obj.checkSiteExists(site_name)){
                                                        main_obj.removeSite(site_name);
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
                                                    }
                                                }
                                                catch(Exception e){
                                                    System.out.println("||EXCEPTION 3|| "+e.getMessage());
                                                }
                                                break;
                                            case 4:// View all Added Sites
                                                try{
                                                    main_obj.printAllAddedSitesName();
                                                }
                                                catch(Exception e){
                                                    System.out.println("||EXCEPTION 4|| "+e.getMessage());
                                                }
                                                break;
                                            case 5:// View Site Details
                                                try{
                                                    System.out.print("|Enter Site Name to View Details:");
                                                    sc.nextLine();
                                                    String site_name = sc.nextLine();
                                                    if(main_obj.checkSiteExists(site_name)){

                                                        main_obj.fetchSiteFileData(site_name);
                                                        System.out.println("|Site/App Details for :"+site_name);
                                                        System.out.println("|Name             :"+decrypt(main_obj.site_info.get(encrypt("site_name"))));
                                                        System.out.println("|URL              :"+decrypt(main_obj.site_info.get(encrypt("site_url"))));
                                                        System.out.println("|Login Email      :"+decrypt(main_obj.site_info.get(encrypt("site_login_email"))));
                                                        System.out.println("|Login Password   :"+decrypt(main_obj.site_info.get(encrypt("site_login_password"))));
                                                        System.out.println("|Password Strength:"+decrypt(main_obj.site_info.get(encrypt("site_login_password_strength"))));
                                                        System.out.println("|Password Hint    :"+decrypt(main_obj.site_info.get(encrypt("site_password_hint"))));
                                                        System.out.println("|Username         :"+decrypt(main_obj.site_info.get(encrypt("site_username"))));
                                                        System.out.println("|User First Name  :"+decrypt(main_obj.site_info.get(encrypt("site_user_first_name"))));
                                                        System.out.println("|User Gender      :"+decrypt(main_obj.site_info.get(encrypt("site_user_gender"))));
                                                        System.out.println("|User Birth Date  :"+decrypt(main_obj.site_info.get(encrypt("site_dob"))));
                                                        System.out.println("|User Phone       :"+decrypt(main_obj.site_info.get(encrypt("site_phone"))));
                                                        System.out.println("|User Note        :"+decrypt(main_obj.site_info.get(encrypt("site_note"))));
                                                        System.out.println("|Data Added At    :"+decrypt(main_obj.site_info.get(encrypt("site_creation"))));
                                                        System.out.println("|Last modified    :"+decrypt(main_obj.site_info.get(encrypt("site_last_modified"))));
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
                                                    }
                                                    
                                                }
                                                catch(Exception e){
                                                    System.out.println("||EXCEPTION 5|| "+e.getMessage());
                                                }
                                                break;
                                            case 6:// View Only Password
                                                try {
                                                    System.out.print("|Enter Site Name to View Password:");
                                                    sc.nextLine();
                                                    String site_name = sc.nextLine();
                                                    if(main_obj.checkSiteExists(site_name)){
                                                        System.out.println("|Password:"+decrypt(main_obj.getSitePasswordOnly(site_name)));
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
                                                    }

                                                } catch (Exception e) {
                                                    System.out.println("||EXCEPTION 6|| "+e.getMessage());
                                                }
                                                break;
                                            case 7:// View Hint Password
                                                try {
                                                    System.out.print("|Enter Site Name to View Half-hidden Password:");
                                                    sc.nextLine();
                                                    String site_name = sc.nextLine();
                                                    if(main_obj.checkSiteExists(site_name)){
                                                        String pass = decrypt(main_obj.getSitePasswordOnly(site_name));
                                                        int pass_len = pass.length();
                                                        String hint_pass = "";
                                                        for(int i = 0; i<pass_len ;i++){
                                                            if(i<pass_len/2){
                                                                hint_pass += "#";
                                                            }
                                                            else{
                                                                hint_pass += pass.charAt(i);
                                                            }
                                                        }
                                                        System.out.println("|Password:"+hint_pass);
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
                                                    }

                                                } catch (Exception e) {
                                                    System.out.println("||EXCEPTION 16|| "+e.getMessage());
                                                }
                                                break;
                                            case 8:// Get Hint About the Password
                                                try {
                                                    System.out.print("|Enter Site Name to Hint about Password:");
                                                    sc.nextLine();
                                                    String site_name = sc.nextLine();
                                                    if(main_obj.checkSiteExists(site_name)){
                                                        String hint = decrypt(main_obj.getHintAboutPassword(site_name));
                                                        System.out.println("|Password hint:"+hint);
                                                    }
                                                    else{
                                                        System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
                                                    }

                                                } catch (Exception e) {
                                                    System.out.println("||EXCEPTION 17|| "+e.getMessage());
                                                }
                                                break;
                                            case 9:// Check Password Strength
                                                try {
                                                    System.out.print("|Enter Any Password to Check Strength:");
                                                    sc.nextLine();
                                                    String pass = sc.nextLine();
                                                    
                                                    String strength = main_obj.getPasswordStrength(pass);
                                                    
                                                    System.out.println("|Password hint:"+strength);

                                                } catch (Exception e) {
                                                    System.out.println("||EXCEPTION 18|| "+e.getMessage());
                                                }
                                                break;
                                            case 10:// Generate random Password
                                                try {
                                                    System.out.println("|Your Random Generated Password:"+main_obj.generateRandomPassword());

                                                } catch (Exception e) {
                                                    System.out.println("||EXCEPTION 19|| "+e.getMessage());
                                                }
                                                break;
                                            case 11:// Generate Custom random Password
                                                try {
                                                    System.out.println("|Your Random Generated Password:"+main_obj.generateCustomRandomPassword());

                                                } catch (Exception e) {
                                                    System.out.println("||EXCEPTION 20|| "+e.getMessage());
                                                }
                                                break;
                                            
                                            case 12:// Log out User
                                                user_logout = true;
                                                break;
                                        
                                            default:
                                                System.out.println("||ERROR|| Invalid Finction Selection!");
                                                break;
                                        }
                                    }
                                    //////////////////////////////////////////////////
                                }
                                else{
                                    main_obj.generateLoginLog(false);
                                    System.out.println("||FAIL|| Invalid login ID or Password! ");
                                }
                            }
                            
                        }
                        else{
                            System.out.println("||FAIL|| Sorry! User doesn't Exist with this email id.");
                        }
                    }
                    catch(Exception e){
                        sc.nextLine();
                        System.out.println("||EXCEPTION 7|| "+e.getMessage());  
                    }

                    break;
                case 2:// Create New User
                    try{   
                        System.out.println("||| Signup |||");
                        String user_aggrement;
                        System.out.print("|Are Your Agree with DevSecureVault's T&C and PRIVACY POLICY.\n|Enter(yes/no):");
                        user_aggrement = sc.next();
                        if(user_aggrement.equalsIgnoreCase("agree")||user_aggrement.equalsIgnoreCase("yes")||user_aggrement.equalsIgnoreCase("y")||user_aggrement.equalsIgnoreCase("ok")){

                            System.out.print("|Enter email id: ");
                            String login_id = sc.next(); // We can add email Email validtaion
                            
                            // Check User Existance
                            boolean user_pre_exist = main_obj.checkUserExists(login_id);

                            if(!user_pre_exist){
                                // proccess for creating new user.
                                if(new File(("./Data/Users/"+encrypt(login_id))).mkdir()){
                                    // Define user File and Folder path to use
                                    // user_info_file
    
                                    System.out.print("|Enter Password:");
                                    // sc.next();
                                    String login_password = sc.nextLine();
                                    login_password = sc.nextLine();
    
                                    System.out.print("|Enter First name:");
                                    String first_name = sc.next().toUpperCase();

                                    System.out.print("|Enter Middle name:");
                                    String middle_name = sc.next().toUpperCase();

                                    System.out.print("|Enter Last name:");
                                    String last_name = sc.next().toUpperCase();
    
                                    System.out.print("|Enter Birth Date(DD/MM/YYYY):");
                                    String birth_date = sc.next();

                                    System.out.print("|Enter Gender(M/F):");
                                    String gender = sc.next();
                                    if(gender.equalsIgnoreCase("m")||gender.equalsIgnoreCase("Male")){
                                        gender = "Male";
                                    }
                                    else if(gender.equalsIgnoreCase("f")||gender.equalsIgnoreCase("Female")){
                                        gender = "Female";
                                    }
                                    else{
                                        gender = "Other";
                                    }                                    
                                    
                                    main_obj.user_info.put(encrypt("login_id"),encrypt(login_id));
                                    main_obj.user_info.put(encrypt("login_password"),encrypt(login_password));
                                    main_obj.user_info.put(encrypt("signup_date_time"),encrypt(LocalDateTime.now().toString()));
                                    main_obj.user_info.put(encrypt("user_agreement"),encrypt("Agree"));
                                    main_obj.user_info.put(encrypt("first_name"),encrypt(first_name));
                                    main_obj.user_info.put(encrypt("middle_name"),encrypt(middle_name));
                                    main_obj.user_info.put(encrypt("last_name"),encrypt(last_name));
                                    main_obj.user_info.put(encrypt("birth_date"),encrypt(birth_date));
                                    main_obj.user_info.put(encrypt("gender"),encrypt(gender));

                                    // create userInfoFile
                                    String userInfoFile = login_id+"/userInfoFile"+login_id;
                                    main_obj.user_info.put(encrypt("userInfoFile"),"./Data/Users/"+encrypt(userInfoFile)+".txt");
                                    File InfoFile = new File(main_obj.user_info.get(encrypt("userInfoFile")));
                                    InfoFile.createNewFile();
                                    FileWriter InfoFileWriter = new FileWriter(InfoFile);
                                    

                                    // create userLoginLogsFile
                                    String userLoginLogsFile = login_id+"/userLoginLogsFile"+login_id;
                                    main_obj.user_info.put(encrypt("userLoginLogsFile"),"./Data/Users/"+encrypt(userLoginLogsFile)+".txt");
                                    File LoginLogsFile = new File(main_obj.user_info.get(encrypt("userLoginLogsFile")));
                                    LoginLogsFile.createNewFile();
                                    LoginLogsFile.setReadOnly();

                                    // create userLoginAttempts
                                    String userLoginAttemptsFile = login_id+"/userLoginAttemptsFile"+login_id;
                                    main_obj.user_info.put(encrypt("userLoginAttemptsFile"),"./Data/Users/"+encrypt(userLoginAttemptsFile)+".txt");
                                    File LoginAttemptsFile = new File(main_obj.user_info.get(encrypt("userLoginAttemptsFile")));
                                    LoginAttemptsFile.createNewFile();
                                    LoginAttemptsFile.setReadOnly();

                                    // create userSecurityQuestionsFile
                                    String userSecurityQuestionsFile = login_id+"/userSecurityQuestionsFile"+login_id;
                                    main_obj.user_info.put(encrypt("userSecurityQuestionsFile"),"./Data/Users/"+encrypt(userSecurityQuestionsFile)+".txt");
                                    File SecurityQuestionsFile = new File(main_obj.user_info.get(encrypt("userSecurityQuestionsFile")));
                                    SecurityQuestionsFile.createNewFile();
                                    FileWriter SecurityQuestionsFileWriter = new FileWriter(SecurityQuestionsFile);

                                    // create userAppDataFolder
                                    String userAppDataFolder = login_id+"/userAppDataFolder"+login_id;
                                    main_obj.user_info.put(encrypt("userAppDataFolder"),"./Data/Users/"+encrypt(userAppDataFolder));
                                    File AppDataFolder = new File(main_obj.user_info.get(encrypt("userAppDataFolder")));
                                    AppDataFolder.mkdir();

                                    // create sub folders of userAppDataFolder --> userSitesDataFolder
                                    String userSitesDataFolder = main_obj.user_info.get(encrypt("userAppDataFolder")) + encrypt("/userSitesDataFolder"+login_id) ; 
                                    main_obj.user_info.put(encrypt("userSitesDataFolder"),userSitesDataFolder);
                                    File SitesDataFolder = new File(userSitesDataFolder);
                                    SitesDataFolder.mkdir();

                                    // create sub folders of userAppDataFolder --> userSitesDataFolder
                                    String userFormsDataFolder = main_obj.user_info.get(encrypt("userAppDataFolder")) + encrypt("/userFormsDataFolder"+login_id) ; 
                                    main_obj.user_info.put(encrypt("userFormsDataFolder"),userFormsDataFolder);
                                    File FormsDataFolder = new File(userFormsDataFolder);
                                    FormsDataFolder.mkdir();

                                    Set <Map.Entry<String,String>>  s = main_obj.user_info.entrySet();
                                    for(Map.Entry entry : s){
                                        InfoFileWriter.write(entry.toString()+"\n");
                                        InfoFileWriter.flush();
                                    }
                                    InfoFile.setReadOnly();

                                    System.out.println("||SUCCESS|| User Successfully Created.");
                                    InfoFileWriter.close();
                                    SecurityQuestionsFileWriter.close();

                                }
                                else{
                                    System.out.println("||ERROR|| Something went wrong! [new User Not Created.]");
                                }
                            }
                            else{
                                System.out.println("||FAIL|| Sorry! User already Exist with this email id.");
                            }
                        }
                        else{
                            System.out.println("||NOTE|| You must AGREE to T&C and PRIVACY POLICY. To use this Syatem.");
                        }
                    }
                    catch(Exception e){
                        System.out.println("||EXCEPTION 8|| "+e.getMessage());
                    }
                    
                    break;
                case 3:
                    // loop_flag = false;
                    System.out.println("+==================THANK-YOU===================+");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("||ERROR|| Invalid Option Selection.");
                    break;
            }
            // System.out.print("\033[H\033[2J"); 
            // System.out.flush();
            // System.out.println("+----------------------------------------------+");
            // System.out.println("|           WELCOME TO DevSecureVault          |");
            // System.out.println("+---------------------------------By-Dev-Shah--+");
            System.out.println("+==============================================+");
        }while(true);
    }
    static String encrypt(String data){
        // for(int i = 0 ; i<data.length();) // logic to handle '"\ or space or =
        // String key =" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"; // removed: "' =\
        // "!#$%&()*+,-./0123456789:;<>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~" // also removed: /\:*?"<>|.
        


        //test key 1
        // String key = "!#$%&()+,-0123456789;@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{}~";
        //test key 2
        String key = "!#$%&()+0123456789@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]abcdefghijklmnopqrstuvwxyz{}";
        // (#addLater For Security,Store key in seprate file and Access it from there.)

        String encrypted_data = "";
        int key_length = key.length();
        for(char c : data.toCharArray()){
            int temp_char_index = key.indexOf(c);
            if(temp_char_index!=-1){
                encrypted_data += key.charAt(key_length-1-temp_char_index);
            }
            else{
                encrypted_data += c;
            }
        }        
        return encrypted_data;
    }
    
    static String decrypt(String data){
        return encrypt(data);
    }
    

    String generateRandomPassword(){
        String s = "!#$%&()+0123456789@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]abcdefghijklmnopqrstuvwxyz{}";
        Random random = new Random();
        int password_length = random.nextInt(4) + 8;
        String password = "";
        for(int i = 0 ; i<password_length ; i++){
            password += s.charAt((random.nextInt(s.length())));
        }   
        return password;     
    }

    String generateCustomRandomPassword(){
        Scanner sc = new Scanner(System.in);
        // sc.next();
        System.out.print("Enter comma seprated keywords :");
        String keyword_string = sc.nextLine();
        String[] keyword_array = keyword_string.split(",");
        String s = "!#$%&()+0123456789@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]abcdefghijklmnopqrstuvwxyz{}";
        Random random = new Random();
        int password_length = random.nextInt(3) + 6;
        String password = "";
        for(int i = 0 ; i<password_length ; i++){
            password += s.charAt((random.nextInt(s.length())));
        }   

        ArrayList<String> temp = new ArrayList<String>();
        // ArrayList<String> temp = new String[(password.toCharArray().length+keyword_array.length)];
        for(char c : password.toCharArray()){
            temp.add(""+c);
        }
        for(String keyword : keyword_array){
            temp.add(keyword);
        }
        Collections.shuffle(temp);
        String custom_password = "";
        for(Object o : temp.toArray()){
            custom_password += (String)o;
        }
        return custom_password;     
    }

    boolean checkUserExists(String login_id){
        boolean user_exist = false;
        for(File file : f.listFiles()){
            if(encrypt(login_id).equals(file.getName())){
                user_exist = true;
                break;
            }
        }
        return user_exist;
    }

    boolean checkSiteExists(String site_name){
        boolean site_exist = false;
        // main_obj.user_info.get(encrypt("userSitesDataFolder"))+"/"+encrypt(site_name)+".txt"
        File folder = new File(user_info.get(encrypt("userSitesDataFolder"))); 
        for(String file : folder.list()){
            if((encrypt(site_name)+".txt").equals(file)){
                site_exist = true;
                break;
            }
        }
        return site_exist;
    }
    
    void removeSite(String site_name){
        try{
            if (checkSiteExists(site_name)) {
                File siteFile = new File(user_info.get(encrypt("userSitesDataFolder"))+"/"+encrypt(site_name)+".txt");
                if(siteFile.delete()){
                    System.out.println("||SUCCESS|| Site Successfully Removed.");
                }
            }
            else{
                System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
            }
        }
        catch(Exception e){
            System.out.println("||EXCEPTION 9|| "+e.getMessage());
        }
    }
    
    String getSitePasswordOnly(String site_name){
        fetchSiteFileData(site_name);
        String temp = site_info.get(encrypt("site_login_password"));
        // site_info.clear();
        return temp;
    }
    String getHintAboutPassword(String site_name){
        fetchSiteFileData(site_name);
        String temp = site_info.get(encrypt("site_password_hint"));
        // site_info.clear();
        return temp;
    }
    
    void printAllAddedSitesName(){
        File folder = new File(user_info.get(encrypt("userSitesDataFolder"))); 
        System.out.println("|List of all Added SItes.");
        for(String file : folder.list()){
            System.out.println("|-> "+decrypt(file.split("\\.txt")[0]));
        }
    }

    void updateSitePassword(String site_name){
        try{
            fetchSiteFileData(site_name);
            Scanner sc = new Scanner(System.in);
            System.out.print("|Enter Old Password:");
            String old_password = sc.nextLine();

            if(site_info.get(encrypt("site_login_password")).equals(encrypt(old_password))){
                System.out.print("|Enter New Password:");
                String new_password = sc.nextLine();
                site_info.replace(encrypt("site_login_password"), encrypt(old_password), encrypt(new_password));


                File siteFile = new File(user_info.get(encrypt("userSitesDataFolder"))+"/"+encrypt(site_name)+".txt");
                siteFile.setWritable(true);
                FileWriter siteFileWiter = new FileWriter(siteFile); 
                for(Map.Entry entry : site_info.entrySet()){
                    siteFileWiter.write(entry.toString()+"\n");
                    siteFileWiter.flush();
                }
                siteFileWiter.close();
                siteFile.setReadOnly();
                System.out.println("||SUCCESS|| Password Updated Successfully.");
            }
            else{
                System.out.println("||FAIL|| Incorrect Old Password.");
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("||EXCEPTION 10|| "+e.getMessage());
        }
    }

    void fetchSiteFileData(String site_name){
        try {
            site_info.clear();
            if(checkSiteExists(site_name)){
                File siteFile = new File(user_info.get(encrypt("userSitesDataFolder"))+"/"+encrypt(site_name)+".txt");
                FileReader siteFileReader = new FileReader(siteFile);
                BufferedReader siteFileBufferedReader = new BufferedReader(siteFileReader);

                String entry = siteFileBufferedReader.readLine();
                while (entry!=null) {
                    site_info.put(entry.split("=")[0], entry.split("=")[1]);
                    entry = siteFileBufferedReader.readLine();
                }

                siteFileBufferedReader.close();
                siteFileReader.close();

            }
            else{
                System.out.println("||FAIL|| Sorry! Site doesn't Exists.");
            }

        } catch (Exception e) {
            System.out.println("||EXCEPTION 11|| "+e.getMessage());
        }
    }

    void fetchUserInfo(String login_id){
        try{
            FileReader fr = new FileReader("./Data/Users/"+DevSecureVault.encrypt(login_id+"/userInfoFile"+login_id)+".txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while ( line != null) {
                String[] entry = line.split("=");
                user_info.put(entry[0],entry[1]);
                line = br.readLine();
            }
            
        }
        catch(Exception e){
            System.out.println("||EXCEPTION 12|| "+e.getMessage());
        }
    }

    void generateLoginLog(boolean login_status){
        try{
            String login_result;
            if(login_status==true){
                login_result="success";
            }
            else{
                login_result="fail";
            }
            String userLoginLogsFile = user_info.get(encrypt("userLoginLogsFile"));
            File LoginLogsFile = new File(userLoginLogsFile);
            LoginLogsFile.setWritable(true);
            FileWriter LoginLogsFileWriter = new FileWriter(LoginLogsFile,true);
            LoginLogsFileWriter.write("Login "+login_result+" at "+LocalDateTime.now().toString()+"\n");
            LoginLogsFileWriter.flush();
            LoginLogsFile.setReadOnly();
            LoginLogsFileWriter.close();
            updateLoginAttempts(login_result);
        }
        catch(Exception e){
            System.out.println("||EXCEPTION 13|| "+e.getMessage());
        }
    }
    
    void updateLoginAttempts(String login_result){
        try{
            String userLoginAttemptsFile = user_info.get(encrypt("userLoginAttemptsFile"));
            File LoginAttemptsFile = new File(userLoginAttemptsFile);

            // read old data
            FileReader LoginAttemptsFileReader = new FileReader(LoginAttemptsFile);
            BufferedReader LoginAttemptsFileBufferedReader = new BufferedReader(LoginAttemptsFileReader);

            String oldData = "";
            int null_count = 0;
            String[] attempts = new String[3];
            for(int i = 0 ; i<3 ; i++){
                attempts[i] = LoginAttemptsFileBufferedReader.readLine();
                if(attempts[i]==null){
                    null_count++;
                }
            }
            if(null_count==0){
                for(int i = 1; i<3 ; i++){
                    oldData = oldData + attempts[i] + "\n";
                }
            }
            else if(null_count==1){
                for(int i = 0; i<2 ; i++){
                    oldData = oldData + attempts[i] + "\n";
                }
            }
            else if(null_count==2){
                oldData = oldData + attempts[0] + "\n";
            }


            // write old + new data (very small in size)
            LoginAttemptsFile.setWritable(true);
            FileWriter LoginAttemptsFileWriter = new FileWriter(LoginAttemptsFile);
            LoginAttemptsFileWriter.write(oldData + "Login "+login_result+" at "+LocalDateTime.now().toString()+"\n");
            LoginAttemptsFileWriter.flush();
            LoginAttemptsFile.setReadOnly();
            LoginAttemptsFileWriter.close();
        }
        catch(Exception e){
            System.out.println("||EXCEPTION 14|| "+e.getMessage());
        }
    }

    boolean blockUserLogin(){
        try{
            String userLoginAttemptsFile = user_info.get(encrypt("userLoginAttemptsFile"));
            File LoginAttemptsFile = new File(userLoginAttemptsFile);
            FileReader LoginAttemptsFileReader = new FileReader(LoginAttemptsFile);
            BufferedReader LoginAttemptsFileBufferedReader = new BufferedReader(LoginAttemptsFileReader);
            boolean all_fail_attempts = true;
            
            String[] attempts = new String[3];
            for(int i = 0 ; i<3 ; i++){
                attempts[i] = LoginAttemptsFileBufferedReader.readLine();
            }
            for(int i = 0 ; i<3 ; i++){
                if(attempts[i]!=null){
                    if(attempts[i].contains("success")){
                        all_fail_attempts = false;
                        break;
                    }
                }
                else{
                    all_fail_attempts = false;
                    break;
                }
            }
            LoginAttemptsFileBufferedReader.close();
            if(all_fail_attempts && attempts[2]!=null){
                LocalDateTime currentTime = LocalDateTime.now();
                HashMap<String,Integer> last_attempt = getDateTimeFromString(attempts[2]==null?(attempts[1]==null?attempts[0].split(" ")[3]:attempts[1].split(" ")[3]):attempts[2].split(" ")[3]);      // chage later
                boolean same_year = currentTime.getYear()==last_attempt.get("year");
                boolean same_month = currentTime.getMonthValue()==last_attempt.get("month");
                boolean same_day = currentTime.getDayOfMonth()==last_attempt.get("day");
                boolean same_hour = currentTime.getHour()==last_attempt.get("hour");
                int minute_difference = currentTime.getMinute()-last_attempt.get("minute");
                
                if(same_year && same_month && same_day && same_hour && (minute_difference<loginAttemptBolckTime)){
                    System.out.println("||FAIL|| Try Again after "+(loginAttemptBolckTime-minute_difference)+" minutes.");
                    return true;
                }
                else{
                    return false;
                }
            }

        }
        catch(Exception e){
            System.out.println("||EXCEPTION 15|| "+e.getMessage());
        }
        return false;
    }

    HashMap<String,Integer> getDateTimeFromString(String dateTimeString){
        HashMap<String,Integer> dt = new HashMap<String,Integer>();
        //dateTimeString => 2024-04-19T12:14:30.102002100
        try{
            String d = dateTimeString.split("T")[0];
            String t = dateTimeString.split("T")[1];
            dt.put("year", Integer.parseInt(d.split("-")[0]));
            dt.put("month", Integer.parseInt(d.split("-")[1]));
            dt.put("day", Integer.parseInt(d.split("-")[2]));
            dt.put("hour", Integer.parseInt(t.split(":")[0]));
            dt.put("minute", Integer.parseInt(t.split(":")[1]));
            dt.put("second", (int)Double.parseDouble(t.split(":")[2]));
        }
        catch(Exception e){
            System.out.println();
        }

        return dt;
    }

    String getPasswordStrength(String password){
        String strength;
        boolean lowercase = false;
        boolean uppercase = false;
        boolean special_char = false;
        boolean digit = false;
        boolean min_length_8_char = false;
        if(password.length()>=8){
            min_length_8_char =true;
        }
        String s_chars = "!@#$%^&*()_+<>?~`|{}[]";
        for(char c : s_chars.toCharArray())
        {
            if(password.contains(""+c)){
                special_char =true;
                break;
            }
        }

        for(char c : password.toCharArray()){
            if(Character.isDigit(c)){
                digit = true;
            }
            if(Character.isLowerCase(c)){
                lowercase = true;
            }
            if(Character.isUpperCase(c)){
                lowercase = true;
            }

        }

        if(lowercase && uppercase && special_char && digit && min_length_8_char){
            strength = "strong";
        }
        else if(lowercase && uppercase && special_char && !digit && min_length_8_char){
            strength = "strong";
        }
        else if(lowercase && uppercase && !special_char && digit && min_length_8_char){
            strength = "strong";
        }
        else if(!min_length_8_char){
            strength = "weak";
        }
        else if(lowercase && uppercase && !special_char && !digit && !min_length_8_char){
            strength = "weak";
        }
        else if((lowercase && uppercase && special_char && digit) || (!min_length_8_char)){
            strength = "medium";
        }
        else if((lowercase || uppercase) && (special_char || digit) && min_length_8_char){
            strength = "medium";
        }
        else if((lowercase || uppercase) && !(special_char || digit) && min_length_8_char){
            strength = "weak";
        }
        else{
            strength = "weak";
        }
        return strength;
    }
}