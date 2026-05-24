package Student;

class Teammember
{
    String name;
    int id;
    String pos;
    public Teammember(String n,int i,String p)
    {
        this.id=i;
        this.name=n;
        this.pos=p;
    }
    public void print()
    {
        System.out.println("姓名：" + name + "，ID：" + id + "，角色：" + pos);
    }
}

public class football
{
    String teamname;
    Teammember[] member;
    int count;
    public football(String teamName) 
    {
        this.teamname = teamName;
        this.member = new Teammember[3];
        this.count = 0;
    }
    public void addMember(Teammember m)
    {
        if(count < member.length)
        {
            member[count] = m;
            count++;
        }
    }
    public void showTeamInfo()
    {
        System.out.println("球队：" + teamname);
        for(int i=0;i<count;i++)
        {
            member[i].print();
        }
    }
    public static void main(String[] args)
    {
        football ft = new football("梦想足球队");
        Teammember t1 = new Teammember("C罗",7,"前锋");
        Teammember t2 = new Teammember("梅西",10,"前锋");
        Teammember t3 = new Teammember("姆巴佩",9,"前锋");
        ft.addMember(t1);
        ft.addMember(t2);
        ft.addMember(t3);
        ft.showTeamInfo();
    }
}