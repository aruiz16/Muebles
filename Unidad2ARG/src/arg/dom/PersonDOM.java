package arg.dom;

import java.util.List;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import arg.model.Person;

public class PersonDOM {
	//private String pathFile = "src/arg.data/persons.xml";
	private String pathFile = "C:\\Users\\Alejandro RG\\eclipse-workspace\\Unidad2ARG\\src\\arg\\data\\persons.xml";

	public void add(Person data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element persons = document.getDocumentElement();
			// Create student tag
			Element person = document.createElement("person");
			// Create id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			person.appendChild(id);
			// Create blood tag
			Element blood = document.createElement("blood");
			blood.appendChild(document.createTextNode(data.getBlood()));
			person.appendChild(blood);
			// Create height tag
			Element height = document.createElement("height");
			height.appendChild(document.createTextNode(data.getHeight()));
			person.appendChild(height);
			// Create height tag
			Element weight = document.createElement("weight");
			weight.appendChild(document.createTextNode(data.getWeight()));
			person.appendChild(weight);
			persons.appendChild(person);
			// Write to file
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("person");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element person = (Element) nodeList.item(i);
				if (person.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					person.getParentNode().removeChild(person);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Person data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("person");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element person = (Element) nodeList.item(i);
				if (person.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					person.getElementsByTagName("blood").item(0).setTextContent(data.getBlood());
					person.getElementsByTagName("height").item(0).setTextContent(data.getHeight());
					person.getElementsByTagName("weight").item(0).setTextContent(data.getWeight());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Person findById(String id) {
		Person person = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("person");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element p = (Element) nodeList.item(i);
				if (p.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					person = new Person();
					person.setId(id);
					person.setBlood(p.getElementsByTagName("blood").item(0).getTextContent());
					person.setHeight(p.getElementsByTagName("height").item(0).getTextContent());
					person.setWeight(p.getElementsByTagName("weight").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return person;
	}

	public List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("person");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element p = (Element) nodeList.item(i);
			Person person = new Person();
			person.setId(p.getElementsByTagName("id")
						.item(0).getTextContent());
			person.setBlood(p.getElementsByTagName("blood")
						.item(0).getTextContent());
			person.setHeight(p.getElementsByTagName("height")
						.item(0).getTextContent());
			person.setWeight(p.getElementsByTagName("weight")
					.item(0).getTextContent());
			persons.add(person);
		}
	return persons;
}
}
