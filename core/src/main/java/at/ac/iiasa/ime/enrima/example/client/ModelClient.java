package at.ac.iiasa.ime.enrima.example.client;
import java.util.List;
import at.ac.iiasa.ime.enrima.example.client.jaxws.GetModelDescriptionRequest;
import at.ac.iiasa.ime.enrima.example.client.jaxws.GetModelDescriptionResponse;
import at.ac.iiasa.ime.enrima.example.client.jaxws.Model;
import at.ac.iiasa.ime.enrima.example.client.jaxws.EnrimaService;
import at.ac.iiasa.ime.enrima.example.client.jaxws.ObjectFactory;
import at.ac.iiasa.ime.enrima.example.client.jaxws.GetModelListResponse;
import at.ac.iiasa.ime.enrima.example.client.jaxws.SaveModelDescriptionRequest;

public class ModelClient {
	EnrimaService service = new EnrimaService();
	ObjectFactory objectFactory = new ObjectFactory();

	public static void main(String[] args) {
		ModelClient client = new ModelClient();
		client.service.setHandlerResolver(new EnrimaHandlerSolver("hongtao","hongtao"));
		//client.getAll();
		
		Model m = client.getById(58);
	}

	public List<Model> getAll() {

	   GetModelListResponse response = service.getEnrimaSoap11().getModelList(null);
	   List<Model> modelList = response.getModel();
	   return modelList;
	}

	public Model getById(int idModel) {
		GetModelDescriptionRequest request = objectFactory
				.createGetModelDescriptionRequest();
		request.setIdModel(idModel);
		GetModelDescriptionResponse response = service.getEnrimaSoap11()
				.getModelDescription(request);
		Model m = response.getModel();
		return m;
	}

	public void save(Model model) {
		SaveModelDescriptionRequest request = objectFactory
				.createSaveModelDescriptionRequest();
		request.setModel(model);
		service.getEnrimaSoap11().saveModelDescription(request);

	}

}
