package kafka.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import kafka.client.model.DepartmentEntity;


public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long>{/*, QuerydslBinderCustomizer<QDepartment> {
  @Override
  default public void customize(
    QuerydslBindings bindings, qDepartment root) {
      bindings.bind(String.class)
        .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
      bindings.excluding(root.email);
    }*/
}