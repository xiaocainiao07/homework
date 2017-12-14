package homework;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserOperate {
    private static Document document;
    private static Element element;


    public static void login(String username,String password) throws DocumentException {
        SAXReader reader = new SAXReader();
        document = reader.read(new File("src/zero.fxml"));
        List<Person> person = listElements();
        for (Object user : person) {
            Person person1 = (Person) user;
            if(username.equals(person1.getUsername())&&password.equals(person1.getPassword())){
                System.out.println("登录成功");
                System.out.println("姓名是"+person1.getName()+"用户名"+person1.getUsername());
            }
        }
    }

    private static List<Person> listElements() throws DocumentException {
        Element rootElement = document.getRootElement();
        List<Element> person = rootElement.elements("persons");
        List<Person> prsonData = new ArrayList<>();
        for (int i = 0; i <person.size(); i++) {
            Element ele = person.get(i);
            Person per = new Person();
            Attribute name = ele.attribute("name");
            String value = name.getValue();
            per.setName(value);

            Element username = ele.element("username");
            Element password = ele.element("password");
            Element job = ele.element("job");
            String text = username.getText();
            String text1 = password.getText();
            String text2 = job.getText();

            per.setUsername(text);
            per.setPassword(text1);
            per.setJob(text2);

            prsonData.add(per);

        }
        return prsonData;
    }

    public static void register(Person person) throws IOException {

        SAXReader reader = new SAXReader();

        try {
            document  = reader.read(new File("src/zero.fxml"));
            element = document.getRootElement();
        } catch (DocumentException e) {
            document = DocumentHelper.createDocument();
            element = document.addElement("Persons");
            element.addText("???");

        }


        Element persons = element.addElement("persons");

        persons.addAttribute("name",person.getName());
        Element names = persons.addElement("names");
        names.addText(person.getName());
        Element username= persons.addElement("username");
        username.addText(person.getUsername());
        Element password = persons.addElement("password");
        password.addText(person.getPassword());
        Element job = persons.addElement("job");
        job.addText(person.getJob());

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/zero.fxml"),outputFormat);
        xmlWriter.write(document);

        xmlWriter.close();
    }




}
