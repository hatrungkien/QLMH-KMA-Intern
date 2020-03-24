import com.dao.TeacherDAO;
import com.model.entity.TblTeacherEntity;

public class Main {
    public static void main(String[] args) {
        TeacherDAO teacher = new TeacherDAO();
        for (TblTeacherEntity t:
             teacher.listAll()) {
            System.out.println(t.getName());
        }
    }

}