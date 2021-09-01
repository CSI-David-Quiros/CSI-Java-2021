package csi.quiros.pkg;

public class Animal {
//	Fields
    String name;
    int age;
    String scientificName;

//  Constructors
	public Animal(String name,int age,String scientificName) {
		this.name = name;
		this.age = age;
		this.scientificName = scientificName;
	}
	public Animal() {
		
	}
	
    //  Getters and Setters  
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    
    public String getScientificName(){
        return scientificName;
    }
    public void setScientificName(String scientificName){
        this.scientificName = scientificName;
    } //  Main Method
    public static void main(String[] args){
        Animal a = new Animal(); 
        a.setName("Aye-aye");
        a.setAge(22);  
        a.setScientificName("Daubentonia madagascariensis");
        
        System.out.println("Name: " + a.getName());
        System.out.println("Age: " + a.getAge());
        System.out.println("Scientific Name: " + a.getScientificName());
        
        Animal a2 = new Animal("Goldfish",3,"Carassius auratus");
        
        System.out.println("Name: " + a2.getName());
        System.out.println("Age: " + a2.getAge());
        System.out.println("Scientific Name: " + a2.getScientificName());
    }
    
}
	


