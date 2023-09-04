package dto;

import java.util.List;

public class PostDTO {
	
	public Integer id;
	
	public Integer userId;
	
	public String title;
	
	public String body;

	public List<CommentDTO> comments;

	public List<HistoryDTO> history;

}
