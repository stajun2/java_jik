package test;

import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {
	public static void main(String[] args) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/pubReliefHospService/getpubReliefHospList"); /*URL*/
    urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=yokZLTATxLSYExFfHZfEWjWDoB6g9Q0fIcgD3rXjIO0bvc7AB5H5QIDdggjBlOqvGMj7ouM7SWGAU24hcvDOEQ%3D%3D"); /*Service Key*/
    //페이지정보. 테스트는 1페이지로함.
    urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
    //한페이지에서 보여지는 결과물 갯수
    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
    //구분코드 : A0: 국민안심병원/97: 코로나검사 실시기관/99: 코로나 선별진료소 운영기관
    urlBuilder.append("&" + URLEncoder.encode("spclAdmTyCd","UTF-8") + "=" + URLEncoder.encode("A0", "UTF-8")); /*A0: 국민안심병원/97: 코로나검사 실시기관/99: 코로나 선별진료소 운영기관*/
    
    DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(urlBuilder.toString());
		
		// root tag 
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		// 파싱할 tag
		NodeList nList = doc.getElementsByTagName("item");
		//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		
		for(int temp = 0; temp < nList.getLength(); temp++){
			Node nNode = nList.item(temp);
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				
				Element eElement = (Element) nNode;
				System.out.println("######################");
				//System.out.println(eElement.getTextContent());
				System.out.println("운영 가능 일자  : " + getTagValue("adtFrDd", eElement));
				System.out.println("선정 유형  : " + getTagValue("hospTyTpCd", eElement));
				System.out.println("시군구명 : " + getTagValue("sgguNm", eElement));
				System.out.println("시도명  : " + getTagValue("sidoNm", eElement));
				System.out.println("구분코드  : " + getTagValue("spclAdmTyCd", eElement));
				System.out.println("전화번호  : " + getTagValue("telno", eElement));
				System.out.println("기관명  : " + getTagValue("yadmNm", eElement));
			}	// for end
		}	// if end
		
	}
	private static String getTagValue(String tag, Element eElement) {
    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
    Node nValue = (Node) nlList.item(0);
    if(nValue == null) 
        return null;
    return nValue.getNodeValue();
	}
}
