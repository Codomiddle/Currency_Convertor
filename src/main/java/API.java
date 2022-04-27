import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class API {
    static String body = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002";

    public static void main(String[] args) {

        class DOMxmlWriter {

            public static void main(String[] args) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder;
                try {
                    builder = factory.newDocumentBuilder();

                    // создаем пустой объект Document, в котором будем
                    // создавать наш xml-файл
                    Document doc = builder.newDocument();
                    // создаем корневой элемент
                    Element rootElement =
                            doc.createElementNS(body, "Currency");

                    //создаем объект TransformerFactory для печати в консоль
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    // для красивого вывода в консоль
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);

                    //печатаем в консоль или файл
                    StreamResult console = new StreamResult(System.out);
                    StreamResult file = new StreamResult(new File("/Users/prologistic/currency.xml"));

                    //записываем данные
                    transformer.transform(source, console);
                    transformer.transform(source, file);
                    System.out.println("Создание XML файла закончено");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            }

        }

    }
