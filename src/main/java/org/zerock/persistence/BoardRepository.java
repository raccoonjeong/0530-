package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{

	@Query(value="select bno, title, content, writer from tbl_board where bno > 0 limit 0, 10", nativeQuery=true) 
	//순수한 자바, sql쿼리가 된다..
	public List<Object[]> getListNative();//네이티브쿼리는 뭐가 나올지 모르기때문에 *오브젝트의 배열타입으로..

	@Query("SELECT b FROM Board b WHERE b.bno > 0 ORDER BY b.bno DESC")//엔티티타입은 정확히 써야함
	public Page<Board> getList(Pageable pageable);
	
	public Page<Board> findByBnoGreaterThan(Long bno, Pageable pageable);
	
	public Page<Board> findByTitleContains(String keyword, Pageable pageable);
	
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable pageable);
	//import org.springframework.data.domain.Pageable;

}
