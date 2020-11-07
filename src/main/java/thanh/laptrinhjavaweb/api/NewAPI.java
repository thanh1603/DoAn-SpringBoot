package thanh.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import thanh.laptrinhjavaweb.api.output.NewOutput;
import thanh.laptrinhjavaweb.dto.NewDTO;
import thanh.laptrinhjavaweb.service.INewService;

//@Controller  //định nghĩa là api ---   
@RestController // @RestController ko cần sử dụng @ResponseBody
//@RestController định nghĩa cả  @Controller +  @ResponseBody
public class NewAPI {
	@Autowired
	private INewService newService;

	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam(value = "page" , required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		NewOutput result = new NewOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			result.setListResult(newService.findAll());
		}

		return result;
	}
	
//	@GetMapping(value = "/new")
//	public NewOutput showNew(@RequestParam(value = "page" , defaultValue = "NONE") String pageStr,
//			@RequestParam(value = "limit", required = false) String limitStr) {
//		NewOutput result = new NewOutput();
//		if ( !pageStr.equals("NONE") &&  !limitStr.equals("NONE")) {
//			int page = Integer.parseInt(pageStr);
//			int limit = Integer.parseInt(limitStr);
//			result.setPage(page);
//			Pageable pageable = new PageRequest(page - 1, limit);
//			result.setListResult(newService.findAll(pageable));
//			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
//		} else {
//			result.setListResult(newService.findAll());
//		}
//
//		return result;
//	}

	// @RequestMapping(value = "/new", method = RequestMethod.POST)
	@PostMapping(value = "/new") // @PostMapping = @RequestMapping +method

//	@ResponseBody  //trả về client với định dạng json  ( part newDTO(data)  ->json)	
	public NewDTO createNew(@RequestBody NewDTO model) { // @RequestBody: //Nhận data từ client , json --> newDTO(data)
		return newService.save(model);
	}

	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);

		return newService.save(model);
	}

	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

}
