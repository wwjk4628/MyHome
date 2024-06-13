package himedia.myhome.dao;

import java.util.List;

import himedia.myhome.vo.UserVo;

public interface UsersDao {
	public List<UserVo> getList();	//	목록
	public boolean insert(UserVo userVo);	//	INSERT
	public boolean update(UserVo userVo);	//	UPDATE
	public boolean delete(Long no);			//	DELETE
	public UserVo getUserByIdAndPassword(String email, 
			String password);	//	Login용
}
