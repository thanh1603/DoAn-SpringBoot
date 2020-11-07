package thanh.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thanh.laptrinhjavaweb.entity.CategoryEntity;

public interface CategoryReposytory extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);// conf lai la viec cua JpaRepository
}
