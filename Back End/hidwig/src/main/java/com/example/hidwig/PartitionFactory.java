package com.example.hidwig;

public class PartitionFactory {
    public IPartition getInstance(String str){
        if(str.equals("Sender") ){
            return new PartitionSender();
        }
        else if(str.equals("Subject") ){
            return new PartitionSubject();
        }
        else if(str.equals("Body") ) {
            return new PartitionBody();
        }
        else if(str.equals("Receiver")) {
            return new PartitionReceive();
        }
        else{
            return new PartitionDate();
        }
    }
    public IPartitionCont getInstanceCont(String str){
        if(str.equals("NameCont") ){
            return new PartitionNameCont();
        }
        else {
            return new PartitionMailCont();
        }
    }
}
