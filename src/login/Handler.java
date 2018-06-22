package login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author samuel
 */
public class Handler {
    
    JSONArray users;
    
    public Handler(){
        users = new JSONArray();
    }
    
    public void saveUser(Object object){ 
        /*Registration*/   
            User user;
            user = (User) object;
            ClassLoader classLoader = new Handler().getClass().getClassLoader();
            //Save user in the .json file
            JSONObject userDetails = new JSONObject();
                userDetails.put("name",user.getName());
                userDetails.put("lastname",user.getLastname());
                userDetails.put("password",user.getPassword());
            JSONObject userObject = new JSONObject();
                userObject.put(user.getUsername(),userDetails);
            
            //System.out.println(userObject);
            //Read de json file first 
            // & Actualizar users (JSONArray)
            JSONParser jsonParser = new JSONParser();
            
            try(FileReader reader = new FileReader(classLoader.getResource("data/usuarios.json").getFile()))
            {
                Object obj;
                try {
                    obj = jsonParser.parse(reader);
                    users = (JSONArray) obj;
                    users.add(userObject);
                    //System.out.println(users);
                    reader.close();
                    
                } catch (ParseException ex) {
                    Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
               users = new JSONArray();
               users.add(userObject);
            }
            //END Read json file
            
            //Write the Json File
            
            try(FileWriter userFile = new FileWriter("src/data/usuarios.json")){
                userFile.write(users.toJSONString());
                userFile.flush();
            }catch (IOException e){
                e.printStackTrace();
            }  
            //System.out.println(users);
            
    }
    
    public Boolean verifignUser(Object object){
        Boolean verifign = false;
        User user = (User) object;
        String username = user.getUsername();
        String password = user.getPassword();
        ClassLoader classLoader = new Handler().getClass().getClassLoader();
        
        //Read the user file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(classLoader.getResource("data/usuarios.json").getFile()))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;
            
            System.out.println(userList);
            //System.out.println(users);
            String u_password = "";
            //System.out.println(userList);
            for(Object o : userList){
               JSONObject u = (JSONObject) o;
               JSONObject us = (JSONObject) u.get(username);
               
               if(us != null){
                   u_password = (String) us.get("password");
                   System.out.println(u_password);
                   if(u_password.equals(password)){
                       verifign = true;
                       break;
                   }else{
                       verifign = false;
                       break;
                   }
               }

            }
            
        }catch (IOException e){
                e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        return verifign;
    }
    
        public String getData(String dataSpecification,Object object){
        User user = (User) object;
        String data = "";
        String username = user.getUsername();
        ClassLoader classLoader = new Handler().getClass().getClassLoader();
        //Read the user file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(classLoader.getResource("data/usuarios.json").getFile()))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;

            String u_password = "";
            
            for(Object o : userList){
               JSONObject u = (JSONObject) o;
               JSONObject us = (JSONObject) u.get(username);
               
               if(us != null){
                   data = (String) us.get(dataSpecification);
               }

            }
            
        }catch (IOException e){
                e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
        
        return data;
    }

    
}
