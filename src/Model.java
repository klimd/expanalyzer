import java.io.*;
import java.util.*;
import org.bson.Document;
import com.mongodb.*;
import com.mongodb.client.*;

public class Model 
{
	private String m_Pathfield;
	private int NumOfExplanations;
	
	private List<Double> DerivProb = new ArrayList<Double>();
	private List<Double> RootProb = new ArrayList<Double>();			// To clear out the array so that
	private List<String> InitialState = new ArrayList<String>();     // the document does not repeat with
	private List<String> FinalState = new ArrayList<String>();       // roots from previous explanations
	private List<String> Roots = new ArrayList<String>();
	
	public void setPathField (String m_pathfield)
	{
		m_Pathfield = m_pathfield;
	}
	public String getPathField()
	{
		return m_Pathfield;
	}
	public void insertMongo() throws Exception
    {
        // *****This is to connect to the database**//
        
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("database");

		MongoCollection<Document> elexirCollection = db.getCollection("test");

		// *********This is to connect to the database***********//
                
                //To clear out existing files from mongo
                db.getCollection("test").deleteMany(new Document());

		// *******This is to read the file into program*********//
		//String fileDirectory = chooser.getCurrentDirectory() + "";
		
              
        FileReader file = new FileReader(getPathField());
		BufferedReader reader = new BufferedReader(file);

		String line = reader.readLine();

		// **********This is to read the text file into program***************//

		// Creating the Array List to store types of variables
		List<String> Types = new ArrayList<String>();
		List<String> Objects = new ArrayList<String>();
		List<String> Predicates = new ArrayList<String>();
		List<String> Cats = new ArrayList<String>();
		List<String> Category = new ArrayList<String>();
		List<String> Action = new ArrayList<String>();

	/*	List<Double> DerivProb = new ArrayList<Double>();
		List<Double> RootProb = new ArrayList<Double>();
		List<String> InitialState = new ArrayList<String>();
		List<String> FinalState = new ArrayList<String>();
		List<String> Roots = new ArrayList<String>();
	*/	
                        
		List <String> Probability = new ArrayList<String>();
		ArrayList<Document> Doc = new ArrayList<Document>();


		// initialize all types of definitions
		String type = null;
		String object = null;
		String predicate = null;
		String cat = null;
		String category = null;
		String action = null;
		String derivProb = null;
		String rootProb = null;
		String initialState = null;
		String finalState = null;
		String roots = null;
        String probability = null;
                

		Document Exp = new Document();
		Document definitions = new Document();
        Document stats = new Document();
                 
                
		// Read type Definitions
		while (line != null) 
		{

			if (line.contains("Defined Type: ")) 
			{
				String types = "Defined Type: ";
				int startingIndexOfType = line.indexOf(types);
				int endingIndexOfType = line.indexOf(".");
				type = line.substring(startingIndexOfType + types.length(),
						endingIndexOfType);
				// putting the piece of string into the new string
				Types.add(type);

			}

			// Read object definitions.
			else if (line.contains("Defined Object: "))
			{
				String objects = "Defined Object: ";
				// this is to split each word from its spaces and print word by word
				int startingIndexOfObj = line.indexOf(objects);
				int endingIndexOfObj = line.indexOf(".");
				object = line.substring(startingIndexOfObj + objects.length(),
						endingIndexOfObj);
				// putting the piece of string into the new string
				Objects.add(object);
			}

			// Read predicate definitions.
			else if (line.contains("Defined predicate:")) 
			{
				String predicates = "Defined predicate:";
				// this is to split each word from its spaces and print word by word
				int startingIndexOfPred = line.indexOf(predicates);
				int endingIndexOfPred = line.indexOf(".");
				predicate = line.substring(startingIndexOfPred + predicates.length(),
						endingIndexOfPred);
				// putting the piece of string into the new string
				Predicates.add(predicate);
			}

			// Defined Cat-Definition
			else if (line.contains("Defined: Cat-Definition: "))
			{
				String catDef = "Defined: Cat-Definition: ";
				// this is to split each word from its spaces and print word by word
				int startingIndexOfCat = line.indexOf(catDef);
				int endingIndexOfCat = line.indexOf(".", startingIndexOfCat );
				cat = line.substring(startingIndexOfCat + catDef.length(), endingIndexOfCat);
				// putting the piece of string into the new string
				Cats.add(cat);
			}
			
			// categories???
			else if (line.contains("Defined: category: ")) 
			{
				String categ = "Defined: category: ";
				// this is to split each word from its spaces and print word by word
				int startingIndexOfCategory = line.indexOf(categ);
				int endingIndexOfCategory = line.indexOf(";", startingIndexOfCategory );
				category = line.substring(startingIndexOfCategory + categ.length(), endingIndexOfCategory);
				// putting the piece of string into the new string
				Category.add(category);	
			}

			// Defined Action Definitions
			else if (line.contains("Defined: ")) 
			{
				String defined = "Defined: ";
				// this is to split each word from its spaces and print word by word
				int startingIndexOfAct = line.indexOf(defined);
				int endingIndexOfAct = line.indexOf(".", startingIndexOfAct );
				action = line.substring(startingIndexOfAct + defined.length(),
						endingIndexOfAct);
				// putting the piece of string into the new string
				Action.add(action);

			}
			
			line = reader.readLine();
			definitions = new Document();
			 if (line.startsWith("Read goals for query."))
				break;
			
		}
                
        //add fields to document
		definitions.append("Types", Types)
				.append("Objects", Objects)
				.append("Predicates", Predicates)
				.append("Cats", Cats)
				.append("Category", Category)
				.append("Actions", Action);

		//insert the document into the collection
		elexirCollection.insertOne(definitions);
                
                
		while (line != null)
		{
			String found = "Found ";
			if (line.contains(found))
			{
				int startingIndexOfFound = line.indexOf(found);
				int endingIndexOfFound = line.indexOf("Explanations.");
				String NumOfExp = line.substring(startingIndexOfFound + found.length(), endingIndexOfFound-2);
				NumOfExplanations = Integer.parseInt(NumOfExp);
			}
			
			DerivProb = new ArrayList<Double>();
			RootProb = new ArrayList<Double>();			// To clear out the array so that
			InitialState = new ArrayList<String>();     // the document does not repeat with
			FinalState = new ArrayList<String>();       // roots from previous explanations
			Roots = new ArrayList<String>();
				
			if (line.startsWith("[Exp:")) 
			{
				String dp = "derivProb: ";
				int startingIndexOfDP = line.indexOf(dp);
				int endingIndexOfDP = line.indexOf(" rootProb", startingIndexOfDP);
				derivProb = line.substring(startingIndexOfDP + dp.length(), endingIndexOfDP);
                DerivProb.add(Double.parseDouble(derivProb));
            
                String rp = "rootProb: ";
				int startingIndexOfRP = line.indexOf(rp);
				int endingIndexOfRP = line.indexOf(" Initial", startingIndexOfRP);
				rootProb = line.substring(startingIndexOfRP + rp.length(), endingIndexOfRP);
				RootProb.add(Double.parseDouble(rootProb));
				//System.out.println(RootProb);
				String is = "Initial State:[ ";
				int startingIndexOfIS = line.indexOf(is);
				int endingIndexOfIS = line.indexOf(" ]", startingIndexOfIS);
				initialState = line.substring(startingIndexOfIS + is.length(),
						endingIndexOfIS);
				InitialState.add(initialState);

				String fs = "Final State:[ ";
				int startingIndexOfFS = line.indexOf(fs);
				int endingIndexOfFS = line.indexOf(" ]", startingIndexOfFS);
				finalState = line.substring(startingIndexOfFS + fs.length(),
						endingIndexOfFS ); // capture last 
				FinalState.add(finalState);
				
				String rootStr = "root:[";
				for (int x = line.indexOf(rootStr); x > -1; x = line.indexOf(
						rootStr, ++x)) 
				{
					int endingIndexOfRoot = line.indexOf("]", x);
					roots = line.substring(x + rootStr.length(),
							endingIndexOfRoot);
					Roots.add(roots);
				}

				Exp = new Document();
				Exp.append("derivProb", Arrays.asList(derivProb))
						.append("rootProb", Arrays.asList(rootProb))
						.append("initialState", Arrays.asList(initialState))
						.append("finalState", Arrays.asList(finalState))
						.append("Roots", Roots);
				
                Doc.add(Exp);
				elexirCollection.insertOne(Exp);

			}
                              
            else //if (!line.startsWith("[Exp:"))
            {
            	// System.out.println(line);
            	if (line.contains("Probabilites:"))
            	{
            		//System.out.println("At line equals prob");
            		while (!line.contains("*** Done with problem. ***") )
            		{
            			//read each line and save here
            			probability += line + "\n"; 
            			//System.out.println(probability);
            			line = reader.readLine();
            		}
            		Probability.add(probability);    
            		stats.append("Probability", Probability);
            		elexirCollection.insertOne(stats);
            	}
            }
			
			line = reader.readLine();
		}// end while loop 

		//FindIterable<Document> iter = elexirCollection.find();
		System.out.println("Your Documents have been stored into mongoDB ");
		System.out.println("NumOfExplanations: " + NumOfExplanations);
    }//end method
	public int getNumOfExplanations()
	{
		System.out.println(NumOfExplanations);
		return NumOfExplanations;
	}
	
}
	
	
	