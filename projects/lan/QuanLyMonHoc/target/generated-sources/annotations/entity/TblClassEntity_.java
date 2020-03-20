package entity;

import com.model.entity.TblAssistantEntity;
import com.model.entity.TblClassEntity;
import com.model.entity.TblStudentEntity;
import com.model.entity.TblTeacherEntity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TblClassEntity.class)
public abstract class TblClassEntity_ {

	public static volatile CollectionAttribute<TblClassEntity, TblStudentEntity> tblStudentEntities;
	public static volatile SingularAttribute<TblClassEntity, String> name;
	public static volatile CollectionAttribute<TblClassEntity, TblTeacherEntity> tblTeacherEntities;
	public static volatile SingularAttribute<TblClassEntity, Integer> id;
	public static volatile CollectionAttribute<TblClassEntity, TblAssistantEntity> tblAssistantEntities;

	public static final String TBL_STUDENT_ENTITIES = "tblStudentEntities";
	public static final String NAME = "name";
	public static final String TBL_TEACHER_ENTITIES = "tblTeacherEntities";
	public static final String ID = "id";
	public static final String TBL_ASSISTANT_ENTITIES = "tblAssistantEntities";

}

