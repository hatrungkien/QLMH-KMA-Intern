package entity;

import com.model.entity.TblClassEntity;
import com.model.entity.TblStudentEntity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TblStudentEntity.class)
public abstract class TblStudentEntity_ {

	public static volatile SingularAttribute<TblStudentEntity, String> name;
	public static volatile SingularAttribute<TblStudentEntity, Integer> id;
	public static volatile CollectionAttribute<TblStudentEntity, TblClassEntity> tblClassEntities;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TBL_CLASS_ENTITIES = "tblClassEntities";

}

