import com.controller.dao.AssistantDAO;
import com.controller.dao.ClassDAO;
import com.controller.dao.StudentDAO;
import com.controller.dao.TeacherDAO;
import com.model.entity.TblClassEntity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO student = new StudentDAO();
        ClassDAO clazz = new ClassDAO();
        AssistantDAO assistant = new AssistantDAO();
        TeacherDAO teacher = new TeacherDAO();
        Scanner sc = new Scanner(System.in);
/*
        student.uc_Create("Nguyen Van A");
        student.uc_Create("Nguyen Van B");
        student.uc_Create("Nguyen Van C");
        clazz.uc_Create("Tin Hoc");
        clazz.uc_Create("Hoa Hoc");
        clazz.uc_Create("Van Hoc");
        assistant.uc_Create("Tro Giang A");
        assistant.uc_Create("Tro Giang B");
        assistant.uc_Create("Tro Giang C");
         teacher.uc_Create("Giao Vien A");
         teacher.uc_Create("Giao Vien B");
         teacher.uc_Create("Giao Vien C");
*/
        clazz.uc_ShowAll();
        student.uc_ShowAll();
        assistant.uc_ShowAll();
        teacher.uc_ShowAll();
        int nextStep = 0;
        do {
        System.out.println("Chon viec ban muon:");
        System.out.println("Nhap 0 de thoat");
        System.out.println("Nhap 1 de tao mot sinh vien");
        System.out.println("Nhap 2 de tao mot sinh lop hoc");
        System.out.println("Nhap 3 de tao giao vien");
        System.out.println("Nhap 4 de tao tro giang");
        System.out.println("Nhap 5 de them giao vien vao lop hoc");
        System.out.println("Nhap 6 de them sinh vien vao lop hoc (dang ky hoc):");
        System.out.println("Nhap 7 de tra thong tin lop hoc Note: Ham nay hien dang loi stackoverflow");
        int choice = 0;
        choice = Integer.valueOf(sc.nextInt());
        switch (choice)
        {
            case 0:
            {
                nextStep =0;
                break;
            }
            case 1:
            {
                System.out.println("Nhap ten sinh vien:");
                sc.nextLine();
                String studentName = sc.nextLine();
                student.uc_Create(studentName);
                System.out.println("Nhung sinh vien hien tai:");
                student.uc_ShowAll();
                break;
            }
            case 2:
            {
                System.out.println("Nhap ten mon hoc:");
                sc.nextLine();
                String className = sc.nextLine();
                clazz.uc_Create(className);
                System.out.println("Nhung mon hoc hien tai:");
                clazz.uc_ShowAll();
                break;
            }
            case 3:
            {
                System.out.println("Nhap ten giao vien:");
                sc.nextLine();
                String teacherName = sc.nextLine();
                teacher.uc_Create(teacherName);
                System.out.println("Nhung giao vien hien tai:");
                teacher.uc_ShowAll();
                break;
            }
            case 4:
            {
                System.out.println("Nhap ten tro giang:");
                sc.nextLine();
                String assistantName = sc.nextLine();
                assistant.uc_Create(assistantName);
                System.out.println("Nhung tro giang hien tai:");
                assistant.uc_ShowAll();
                break;
            }
            case 5:
            {
                System.out.println("Danh sach Giao vien:");
                teacher.uc_ShowAll();
                System.out.println("Danh sach lop hoc:");
                clazz.uc_ShowAll();
                System.out.println("Nhap ID lop ban muon them: ");
                sc.nextLine();
                int clazz_id = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap ID giao vien ban muon them vao:");
                int teacher_id = Integer.parseInt(sc.nextLine());
                clazz.uc_AddTeacherToClass(clazz_id,teacher_id);
                break;
            }
            case 6:
            {
                System.out.println("Danh sach sinh vien:");
                student.uc_ShowAll();
                System.out.println("Danh sach lop hoc:");
                clazz.uc_ShowAll();
                System.out.println("Nhap ID sinh vien ban muon them: ");
                sc.nextLine();
                int student_id = Integer.parseInt(sc.nextLine());
                System.out.println("Nhap ID lop ban muon them vao:");
                int clazz_id = Integer.parseInt(sc.nextLine());
                clazz.uc_AddStudentToClass(clazz_id,student_id);
                break;
            }
            case 7:
            {
                System.out.println("Danh sach lop hoc:");
                clazz.uc_ShowAll();
                System.out.println("Nhap ID lop ban muon xem thong tin: ");
                sc.nextLine();
                int clazz_id = Integer.parseInt(sc.nextLine());
                clazz.uc_findClassInfo(clazz_id);
                break;
            }
        }
            System.out.println("Ban co muon tiep tuc khong?");
            System.out.println("Chon 1 de tiep tuc, 0 de ngung chuong trinh");
            nextStep = sc.nextInt();
        }while (nextStep != 0);
        clazz.uc_ShowAll();
        student.uc_ShowAll();
        assistant.uc_ShowAll();
        teacher.uc_ShowAll();
    }


}
