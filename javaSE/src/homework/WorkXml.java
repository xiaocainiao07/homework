package homework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkXml {
    public static void WorkXML(Person person) throws IOException, DocumentException {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read(new File("src/zero.fxml"));

        System.out.println(person.getName());
        Element rootElement = document.getRootElement();
        Element user = rootElement.addElement("user");
        user.addAttribute("name",person.getName());
        Element username = user.addElement("username");
        username.addText(person.getUsername());
        Element password=user.addElement("password");
        password.addText(person.getPassword());

        Element job = user.addElement("job");
        job.addText(person.getJob());

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/zero.fxml"));

        xmlWriter.write(document);

        xmlWriter.close();




    }









}
