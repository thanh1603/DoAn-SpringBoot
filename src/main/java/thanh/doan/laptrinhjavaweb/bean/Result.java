package thanh.doan.laptrinhjavaweb.bean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Result {
    private int status;
    private List<String> messgaes;
    private Map<String, String> mesStringByKey  = new LinkedHashMap<String, String>();
    private int total;
    public  List<Object> data;
    public  String idScroll;
    public List<Order> orders;

    public Set<Product> products;

    public  Map<String, Cart> carts;

    private  String fileName;


}
