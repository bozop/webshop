package com.comtrade.daoFacade;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );     
//    	Settings settings = Settings.settingsBuilder().put("cluster.name", "my-application").build();
//
//    	Client client = TransportClient.builder()
//				        .settings(settings)
//				        .build()
//				        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//        
//        
//        
//        //Get API       
//        GetResponse response = client.prepareGet("webshop", "products", "2")
//                .execute()
//                .actionGet();
//
//        System.out.println("----------------Index Output Begin----------------");
//        System.out.println("Index Name: " + response.getIndex());     
//        System.out.println("Type: " + response.getType());
//        System.out.println("Document ID: " + response.getId());
//        System.out.println("Document Version: " + response.getVersion());
//        System.out.println("Source: " + response.getSourceAsString());
    }
}
