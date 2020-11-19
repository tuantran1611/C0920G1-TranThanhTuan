package case_study_module_2.commons;

import case_study_module_2.models.Employee;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class ReadWriteEmployee {
    public static Map<String,Employee> readEmployee(){
        Map<String,Employee> map = new TreeMap<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(new File("src/case_study_module_2/data/Employee.csv")));
            String line;
            String[] strArr;
            Employee employee;
            while ((line = br.readLine()) != null ){
                strArr = line.split(",");
                employee = new Employee(strArr[1],strArr[2],strArr[3]);
                map.put(strArr[0],employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
