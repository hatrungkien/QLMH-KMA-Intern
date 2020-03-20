import javax.annotation.Resource;
public class ClassController {
    ClassService service;

    @Resource
    public void setService(ClassService service){
        this.service = service;
    }
}
