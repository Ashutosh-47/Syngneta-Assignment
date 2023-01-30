package com.example.Syngneta.service;

import com.example.Syngneta.field.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService{
    private final String fileName="C:/Users/91817/Desktop/Syngneta/src/main/java/com/example/Syngneta/service/data.csv";

    public int countOfCommas(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='"')	c++;
        }
        return c;
    }
    public List<Field> readFile(String csvFile) throws Exception{
        File file=new File(csvFile);
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);

        String line="";
        String[] temp;
        List<Field> lines=new ArrayList<Field>();
        while((line=br.readLine())!=null){
            temp=line.split(",");
            ArrayList<String> arr=new ArrayList<String>();
            String prev="";
            for(String str:temp){
                String key="default";
                if(countOfCommas(str)==2){
                    key=str.substring(1,str.length()-1);
                    arr.add(key);
                } else{
                    if(prev.length()!=0)	prev+=",";
                    prev+=str;
                    if(countOfCommas(prev)==2){
                        key=prev.substring(1,str.length()-1);
                        arr.add(key);
                        prev="";
                    }
                }
            }
            Field user=new Field(arr.get(0),arr.get(1),arr.get(2),arr.get(3),arr.get(4), arr.get(5));


            lines.add(user);


        }

        br.close();
        return lines;
    }

    public List<Field> match(String fname,String lname,String addr,String city,String state,String code) throws Exception {
        List<Field>  results=new ArrayList<Field>();
        List<Field> users=readFile(fileName);
        for(int i=0;i<users.size();i++){
            if(fname!=null && users.get(i).getFirstName().equalsIgnoreCase(fname))   results.add(users.get(i));
            else if(lname!=null && users.get(i).getLastName().equalsIgnoreCase(lname))   results.add(users.get(i));
            else if(addr!=null && users.get(i).getAddress1().equalsIgnoreCase(addr))   results.add(users.get(i));
            else if(city!=null && users.get(i).getCity().equalsIgnoreCase(city))   results.add(users.get(i));
            else if(state!=null && users.get(i).getState().equalsIgnoreCase(state))   results.add(users.get(i));
            else if(code!=null && users.get(i).getCode().equalsIgnoreCase(code))   results.add(users.get(i));
        }
        return results;
    }

    public List<Field> getAll() throws Exception{
        List<Field> users=readFile(fileName);
        return users;
    }




}
