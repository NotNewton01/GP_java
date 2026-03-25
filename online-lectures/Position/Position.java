import static java.lang.Math.*;

public class Position{
    private double x;
    private double y;

    public Position(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    
    public Position add (Position pos){
        Position posret = new Position(this.getX()+pos.getX(),this.getY()+pos.getY()); 
        return posret; 
    }
    public Position sub (Position pos){
        Position posret = new Position(this.getX()-pos.getX(),this.getY()-pos.getY()); 
        return posret; 
    }
    public Position add (double f){
        Position posret = new Position(this.getX()+f,this.getY()+f); 
        return posret; 
    }
    public Position sub (double f){
        Position posret = new Position(this.getX()-f,this.getY()-f); 
        return posret; 
    }

    public Position mul(double f){
        Position posret = new Position(this.getX()*f,this.getY()*f); 
        return posret; 
    }
    public Position div(double f){
        Position posret = new Position(this.getX()/f,this.getY()/f); 
        return posret; 
    }

    public double dot(Position pos){
        return this.getX()*pos.getX()+this.getY()*pos.getY(); 
    }

    public double distance(Position pos){
        return sqrt(pow(this.getX()-pos.getX(),2)+pow(this.getY()-pos.getY(),2));
    }

    @Override
    public String toString(){
        return x+"/"+y;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Position)){
            return false;
        }
        if (obj == this ){
            return true;
        }
        Position pos = (Position) obj; //casting from Object into Position
    
        if (getX() != pos.getX()){
            return false;
        }
        else if (getY() != pos.getY()){
            return false;
        }
        return true;
    }


    public static void main(){
        Position p1 = new Position(10, 10);
        Position p2 = new Position(12, 18);
        Position p3 = new Position(17, 16);
        Position p4 = new Position(14, 8);
        Position p5 = new Position(12, 7);
        Position pos[] = new Position[5];
        pos[0]= p1;
        pos[1]= p2;
        pos[2]= p3;
        pos[3]= p4;
        pos[4]= p5;
        Position average = new Position(0,0);
        Position last = pos[pos.length-1];
        double distance=0.0;
        for (Position po : pos) {
            average = po.add(average);
            distance += po.distance(last);
            last = po;
        }
        average=average.div(pos.length);
        System.out.println("Average is: "+average.toString());
        //distance=pos[0].distance(pos[1]);
        System.out.println("Circumvence is: "+distance);
    }

}