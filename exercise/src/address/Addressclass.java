package address;
class Addressclass {
    String name;
    String province;
    String city;
    String street;
    String doorNo;
    String zipCode;

    public Addressclass(String name, String province, String city, String street, String doorNo, String zipCode) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.street = street;
        this.doorNo = doorNo;
        this.zipCode = zipCode;
    }

    static Addressclass[] addrs = new Addressclass[100];
    static int size = 0;

    public static void main(String[] args) {
        add(new Addressclass("张三","江苏","南京","中山路","10","210000"));
        find("张三");
        update("张三","浙江","杭州","西湖路","20","310000");
        delete("张三");
    }

    static void add(Addressclass a) {
        addrs[size++] = a;
        System.out.println("添加成功");
    }

    static int find(String name) {
        for (int i = 0; i < size; i++) {
            if (addrs[i].name.equals(name)) {
                System.out.println("找到");
                return i;
            }
        }
        System.out.println("未找到");
        return -1;
    }

    static void delete(String name) {
        int idx = find(name);
        if (idx == -1) return;
        for (int i = idx; i < size-1; i++)
            addrs[i] = addrs[i+1];
        size--;
        System.out.println("删除成功");
    }

    static void update(String name,String p,String c,String s,String d,String z) {
        int idx = find(name);
        if (idx == -1) return;
        Addressclass a = addrs[idx];
        a.province = p;
        a.city = c;
        a.street = s;
        a.doorNo = d;
        a.zipCode = z;
        System.out.println("修改成功");
    }
}