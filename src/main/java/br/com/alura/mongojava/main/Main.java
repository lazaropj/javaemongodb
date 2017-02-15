package br.com.alura.mongojava.main;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Main {
	
	public static void main(String[] args) {
		
		MongoClient cliente = new MongoClient();
		
		MongoDatabase bancoDeDados = cliente.getDatabase("test");
		
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
		Document primeiroAluno = alunos.find().first();
		System.out.println(primeiroAluno);
		/*Document novoAluno = new Document("nome", "Celina Prates")
				.append("data_nascimento", new Date(2009, 2,9))
				.append("notas", Arrays.asList(10, 9, 8.5))
				.append("curso", new Document("nome", "História"))
				.append("habilidades" , Arrays.asList(
						new Document("nome", "ingles").append("nível", "Avançado"), 
						new Document("nome", "Espanhol").append("nível", "básico")));
		alunos.insertOne(novoAluno);
		Document celina = alunos.find(Filters.eq("nome", "Celinas Prates")).first();
		System.out.println(celina.toJson());*/
		alunos.deleteOne(Filters.eq("nome", "Celina Regina Salomão Prates"));
		cliente.close();
		
		
	}

}
