package bai_tap.tu_dien_map;


import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Tra từ điển Anh-Việt
 * 1.Thêm từ (Từa khoá , ý nghĩa)
 * 2.Xoá từ
 * 3.Tìm ý nghĩa của từ khoá -> tra từ
 * 4.In ra danh sách từ khoá
 * 5.In ra số lượng từ
 * 6.Xoá tất cả các từ khoá.
 */
public class TuDien {
    private Map<String,String> dulieu = new TreeMap<>();

    public String themTu(String tuKhoa , String yNghia){
        return this.dulieu.put(tuKhoa, yNghia);
    }
    public String xoaTu(String tuKhoa){
        return this.dulieu.remove(tuKhoa);
    }
    public String traTu(String tuKhoa){
        String yNghia = this.dulieu.get(tuKhoa);
        return yNghia;
    }
    public void inTuKhoa(){
        Set<String> tapHopTuKhoa = this.dulieu.keySet();
        System.out.println(Arrays.toString(tapHopTuKhoa.toArray()));
    }
    public int laySoluong(){
        return this.dulieu.size();
    }
    public void xoaTatCa(){
        this.dulieu.clear();
    }
}
