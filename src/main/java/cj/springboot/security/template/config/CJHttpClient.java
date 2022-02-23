package cj.springboot.security.template.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class CJHttpClient {


    @Bean
   public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
   }

   /*
   *如何调用 webServiceTemplate  访问免费接口http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl
   * */
    @Bean
    public WebServiceTemplate webServiceTemplate(WebServiceTemplateBuilder webServiceTemplateBuilder){
        return webServiceTemplateBuilder.build();
    }

//    @Bean
//    public JaxWsPortProxyFactoryBean accountWebService() throws MalformedURLException {
//        JaxWsPortProxyFactoryBean bean = new JaxWsPortProxyFactoryBean();
//        bean.setServiceInterface(CJWSClient.class);
//        URL url = new URL("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx?wsdl");
//        bean.setWsdlDocumentUrl(url);
//        bean.setNamespaceUri("http://WebXml.com.cn/");
//        bean.setServiceName("getCountryCityByIp");
//        bean.setPortName("IpAddressSearchWebServiceHttpGet");
//        return  bean;
//    }

}
