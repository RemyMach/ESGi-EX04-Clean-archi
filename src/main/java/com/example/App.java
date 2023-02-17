package com.example;

import com.example.cli.ArgumentParsed;
import com.example.cli.ParseCli;
import com.example.fileReader.MyFileReader;
import com.example.response.OperationsDetailsAdapter;
import com.example.response.TotalCalculusAdapter;
import com.example.usecases.DoOperations;
import com.example.writer.ConsoleWriter;
import com.example.writer.Writer;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Writer writer = new ConsoleWriter();
        ArgumentParsed argumentParsed = new ParseCli().parse(Arrays.stream(args).toList());

        MyFileReader fileReader = new MyFileReader(argumentParsed.getFilename());
        List<String> elements = fileReader.read();

        if(elements.isEmpty()) {
            writer.write("No elements to calculate");
            return;
        }

        DoOperations doOperations = new DoOperations();
        List<Integer> elementsConvert = elements.stream().map(Integer::parseInt).toList();
        List<Integer> operationsResult = doOperations.handle(elementsConvert, argumentParsed.getCalculus());

        String operationDetails = OperationsDetailsAdapter.adaptToHistoryResponse(operationsResult, argumentParsed.getCalculus());
        String totalDetail = TotalCalculusAdapter.toTotalCalculusResponse(operationsResult.get(operationsResult.size() - 1), argumentParsed.getCalculus());
        writer.write(operationDetails);
        writer.write("--------");
        writer.write(totalDetail);
    }

    public String getMessage() {
        return "Hello World!";
    }
}
