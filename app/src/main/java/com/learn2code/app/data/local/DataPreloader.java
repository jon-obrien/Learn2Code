package com.learn2code.app.data.local;

import android.content.Context;

import com.learn2code.app.R;
import com.learn2code.app.data.local.entity.InfoEntity;
import com.learn2code.app.data.local.entity.ModuleEntity;
import com.learn2code.app.data.local.entity.QuestionEntity;
import com.learn2code.app.data.local.entity.TopicEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataPreloader {
    private final Context context;
    private final AppDatabase db;

    public DataPreloader(Context context, AppDatabase db) {
        this.context = context;
        this.db = db;
    }

    public void preloadAll() {
        if (db.moduleDao().getAll().isEmpty()) {
            preloadModules();
            preloadTopics();
            preloadInfos();
            preloadQuestionsFromCsv();
        }
    }

    private void preloadModules() {
        List<ModuleEntity> modules = new ArrayList<>();
        modules.add(new ModuleEntity(1, context.getString(R.string.module_1_title)));
        modules.add(new ModuleEntity(2, context.getString(R.string.module_2_title)));
        modules.add(new ModuleEntity(3, context.getString(R.string.module_3_title)));
        modules.add(new ModuleEntity(4, context.getString(R.string.module_4_title)));
        modules.add(new ModuleEntity(5, context.getString(R.string.module_5_title)));
        modules.add(new ModuleEntity(6, context.getString(R.string.module_6_title)));
        db.moduleDao().insertAll(modules);
    }

    private void preloadTopics() {
        List<TopicEntity> topics = new ArrayList<>();
        topics.add(new TopicEntity(1, 1, context.getString(R.string.topic_1_title)));
        topics.add(new TopicEntity(2, 1, context.getString(R.string.topic_2_title)));
        topics.add(new TopicEntity(3, 1, context.getString(R.string.topic_3_title)));
        topics.add(new TopicEntity(4, 1, context.getString(R.string.topic_4_title)));
        topics.add(new TopicEntity(5, 1, context.getString(R.string.topic_5_title)));
        topics.add(new TopicEntity(6, 2, context.getString(R.string.topic_6_title)));
        topics.add(new TopicEntity(7, 2, context.getString(R.string.topic_7_title)));
        topics.add(new TopicEntity(8, 2, context.getString(R.string.topic_8_title)));
        topics.add(new TopicEntity(9, 2, context.getString(R.string.topic_9_title)));
        topics.add(new TopicEntity(10, 3, context.getString(R.string.topic_10_title)));
        topics.add(new TopicEntity(11, 3, context.getString(R.string.topic_11_title)));
        topics.add(new TopicEntity(12, 3, context.getString(R.string.topic_12_title)));
        topics.add(new TopicEntity(13, 4, context.getString(R.string.topic_13_title)));
        topics.add(new TopicEntity(14, 4, context.getString(R.string.topic_14_title)));
        topics.add(new TopicEntity(15, 4, context.getString(R.string.topic_15_title)));
        topics.add(new TopicEntity(16, 5, context.getString(R.string.topic_16_title)));
        topics.add(new TopicEntity(17, 5, context.getString(R.string.topic_17_title)));
        topics.add(new TopicEntity(18, 6, context.getString(R.string.topic_18_title)));
        topics.add(new TopicEntity(19, 6, context.getString(R.string.topic_19_title)));
        topics.add(new TopicEntity(20, 6, context.getString(R.string.topic_20_title)));
        db.topicDao().insertAll(topics);
    }

    private void preloadInfos() {
        List<InfoEntity> infos = new ArrayList<>();
        addVariableInfos(infos);
        addMathInfos(infos);
        addStringInfos(infos);
        addBooleanInfos(infos);
        addBonusInfos(infos);
        addIfElseInfos(infos);
        addSwitchInfos(infos);
        addWhileInfos(infos);
        addForInfos(infos);
        addFileReadWriteInfos(infos);
        addFileCreateInfos(infos);
        addFileDeleteInfos(infos);
        addFunctionInfos(infos);
        addOverloadingInfos(infos);
        addRecursionInfos(infos);
        addOOPInfos(infos);
        addConstructorInfos(infos);
        addStackInfos(infos);
        addBSTInfos(infos);
        addLinkedListInfos(infos);
        db.infoDao().insertAll(infos);
    }

    private void addVariableInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(1, "Python", "Declare integer (whole number): x = 10\n\nDeclare float (decimal values): x = 10.5\n\nDeclare String (words and letters): s = 'Hello'\n\nDeclare boolean value (True or False): isTrue = True\n\nAssign multiple variables: a = b = c = 'Apple'"));
        infos.add(new InfoEntity(1, "Java", "Declare integer (whole number): int x = 10;\n\nDeclare float (decimal values): float x = 10.5f;\n\nDeclare String (words): String s = 'Hello';\n\nDeclare boolean value (True or False): boolean isTrue = true;\n\nAssign multiple variables: int x = 5, y = 6, z = 7;"));
        infos.add(new InfoEntity(1, "C", "Declare integer (whole number): int x = 10;\n\nDeclare float (decimal values): float x = 10.5f;\n\nDeclare String (words): char s[] = 'Hello';\n\nDeclare boolean value (True or False): int isTrue = 1;\n\nAssign multiple variables: int x = 1, y = 2, z = 3;"));
    }

    private void addMathInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(2, "Python", "Exponentiation: 3 ** 4\n\nRound up: math.ceil(5.3)\n\nSquare root: math.sqrt(16)\n\nAbsolute value: abs(-10)"));
        infos.add(new InfoEntity(2, "Java", "Exponentiation: Math.pow(3, 4);\n\nRound up: Math.ceil(5.3);\n\nSquare root: Math.sqrt(16);\n\nAbsolute value: Math.abs(-10);"));
        infos.add(new InfoEntity(2, "C", "Exponentiation: pow(3, 4);\n\nRound up: ceil(5.3);\n\nSquare root: sqrt(16);\n\nAbsolute value: abs(-10);"));
    }

    private void addStringInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(3, "Python", "Declare string: s = 'String'\n get letter at index i: string[i]\nchange character at index i with 'b': string = 'b' + string[1:]\nget length of string: len(string)\nprint string: print(string)\n concatenate strings: str = str1+str2\ncompare strings: str1==str2"));
        infos.add(new InfoEntity(3, "Java", "Declare String: s=\"String\";\n get letter at index i: .charAt(i)\n; change character at index i to 'b': 'b'+'hello'.substring(i);\nget length of string: string.length();\n print string: System.out.println(string)\nconcatenate string: str = str1+str2;\ncompare string: str1==str2;"));
        infos.add(new InfoEntity(3, "C", "Declare string: char string[]=\"hello\";\nprint a letter at index i: printf(\"%c\", greetings[0]);\nchange the first character of greetings[] = \"Hello\" to 'b': greetings[0] = 'b';\ncalculate the length: sizeof(greetings)\nprint string: printf(\"%s\", greetings);\nconcatenate: strcat(str1,str2)\ncompare: strcmp(str1,str2)"));
    }

    private void addBooleanInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(4, "Python", "2 values: True or False\n\nequal: a==b\nless than: a<b\ngreater than: a>b\nnegation: not a"));
        infos.add(new InfoEntity(4, "Java", "2 values: true or false\n\nequal: a==b\nless than: a<b\ngreater than: a>b\nnegation: !a"));
        infos.add(new InfoEntity(4, "C", "2 values: true or false (0 or 1)\n\nequal: a==b\nless than: a<b\ngreater than: a>b\nnegation: !a"));
    }

    private void addBonusInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(5, "Python", "test"));
        infos.add(new InfoEntity(5, "Java", "Primitive types: boolean, byte, char, short, int, long, float, double"));
        infos.add(new InfoEntity(5, "C", "Types: float(%f), char(%c), int(%d), double(%lf)"));
    }

    private void addIfElseInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(6, "Python", "if else: if(condition):\n    do something\nelse:\n    do this"));
        infos.add(new InfoEntity(6, "Java", "if else: if(condition) {\n    do something\n} else {\n    do this\n}"));
        infos.add(new InfoEntity(6, "C", "if else: if(condition) {\n    do something\n} else {\n    do this\n}"));
    }

    private void addSwitchInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(7, "Python", "Use match keyword with case patterns. Default case defined with _"));
        infos.add(new InfoEntity(7, "Java", "switch(expression) {\n    case x:\n        code\n        break;\n    default:\n        code\n}"));
        infos.add(new InfoEntity(7, "C", "switch(expression) {\n    case x:\n        code\n        break;\n    default:\n        code\n}"));
    }

    private void addWhileInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(8, "Python", "while(condition):\n    do this\n\nUse break() to exit, continue() to skip"));
        infos.add(new InfoEntity(8, "Java", "while(condition) {\n    do this\n}\n\nUse break; to exit, continue; to skip"));
        infos.add(new InfoEntity(8, "C", "while(condition) {\n    do this\n}\n\nUse break; to exit, continue; to skip"));
    }

    private void addForInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(9, "Python", "for i in range(0,5):\n    do this\n\nUse break() to exit, continue() to skip"));
        infos.add(new InfoEntity(9, "Java", "for (int i=0; i<5; i++) {\n    do this\n}\n\nEnhanced for: for(Type item : collection)"));
        infos.add(new InfoEntity(9, "C", "for (int i=0; i<5; i++) {\n    do this\n}\n\nUse break; to exit, continue; to skip"));
    }

    private void addFileReadWriteInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(10, "Python", "open('file', 'r') to read, 'w' to write, 'a' to append\nread(), readline(), close()"));
        infos.add(new InfoEntity(10, "Java", "Scanner to read, FileWriter to write\nFile class for file operations"));
        infos.add(new InfoEntity(10, "C", "fopen(), fgets(), fprintf(), fclose()\nModes: r, w, a, rw"));
    }

    private void addFileCreateInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(11, "Python", "open('file', 'x') creates new file\n'a' mode opens/appends"));
        infos.add(new InfoEntity(11, "Java", "File.createNewFile() creates file\nReturns false if exists"));
        infos.add(new InfoEntity(11, "C", "fopen(filename, 'w') creates file\nOverwrites if exists"));
    }

    private void addFileDeleteInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(12, "Python", "os.remove() deletes file\nos.rmdir() removes empty directory"));
        infos.add(new InfoEntity(12, "Java", "File.delete() deletes file or empty directory"));
        infos.add(new InfoEntity(12, "C", "remove() deletes file\nReturns 0 on success"));
    }

    private void addFunctionInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(13, "Python", "def functionName(param1, param2):\n    return value"));
        infos.add(new InfoEntity(13, "Java", "public ReturnType functionName(Type param1, Type param2) {\n    return value;\n}"));
        infos.add(new InfoEntity(13, "C", "ReturnType functionName(Type param1, Type param2) {\n    return value;\n}"));
    }

    private void addOverloadingInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(14, "Python", "Overloading not directly supported\nUse default arguments instead"));
        infos.add(new InfoEntity(14, "Java", "Multiple methods with same name but different parameters"));
        infos.add(new InfoEntity(14, "C", "Overloading not supported in C"));
    }

    private void addRecursionInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(15, "Python", "def factorial(n):\n    if n <= 1:\n        return 1\n    return n * factorial(n-1)"));
        infos.add(new InfoEntity(15, "Java", "public int factorial(int n) {\n    if (n <= 1) return 1;\n    return n * factorial(n-1);\n}"));
        infos.add(new InfoEntity(15, "C", "int factorial(int n) {\n    if (n <= 1) return 1;\n    return n * factorial(n-1);\n}"));
    }

    private void addOOPInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(16, "Python", "class MyClass:\n    def __init__(self):\n        pass"));
        infos.add(new InfoEntity(16, "Java", "public class MyClass {\n    // fields and methods\n}"));
        infos.add(new InfoEntity(16, "C", "C does not have built-in OOP support\nUse structs and function pointers"));
    }

    private void addConstructorInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(17, "Python", "def __init__(self, param):\n    self.param = param"));
        infos.add(new InfoEntity(17, "Java", "public MyClass(Type param) {\n    this.param = param;\n}"));
        infos.add(new InfoEntity(17, "C", "No direct constructor support\nUse initialization functions"));
    }

    private void addStackInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(18, "Python", "stack = []\nstack.append(item)  # push\nstack.pop()  # pop"));
        infos.add(new InfoEntity(18, "Java", "Stack<Type> stack = new Stack<>();\nstack.push(item);\nstack.pop();"));
        infos.add(new InfoEntity(18, "C", "Use array with top index\npush: arr[++top] = item\npop: arr[top--]"));
    }

    private void addBSTInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(19, "Python", "Binary Search Tree: left < root < right\nInsert: compare and recurse"));
        infos.add(new InfoEntity(19, "Java", "Binary Search Tree: left < root < right\nInsert: compare and recurse"));
        infos.add(new InfoEntity(19, "C", "Binary Search Tree: left < root < right\nInsert: compare and recurse"));
    }

    private void addLinkedListInfos(List<InfoEntity> infos) {
        infos.add(new InfoEntity(20, "Python", "node.next = next_node\ncurrent = current.next"));
        infos.add(new InfoEntity(20, "Java", "node.next = nextNode;\ncurrent = current.next;"));
        infos.add(new InfoEntity(20, "C", "node->next = nextNode;\ncurrent = current->next;"));
    }

    private void preloadQuestionsFromCsv() {
        String[] languages = {"Java", "Python", "C"};
        
        for (int topicId = 1; topicId <= 20; topicId++) {
            for (String lang : languages) {
                String fileName = "questions/topic_" + topicId + "_" + lang.toLowerCase() + ".csv";
                List<QuestionEntity> questions = loadQuestionsFromCsv(topicId, lang, fileName);
                if (!questions.isEmpty()) {
                    db.questionDao().insertAll(questions);
                }
            }
        }
    }

    private List<QuestionEntity> loadQuestionsFromCsv(long topicId, String lang, String fileName) {
        List<QuestionEntity> questions = new ArrayList<>();
        
        try {
            InputStream is = context.getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (parts.length >= 6) {
                    QuestionEntity q = new QuestionEntity();
                    q.topicId = topicId;
                    q.lang = lang;
                    q.questionText = parts[0].replace("\"", "");
                    q.questionCode = parts[1].replace("\"", "");
                    q.correctAnswer = parts[2].replace("\"", "");
                    q.wrongAnswer1 = parts[3].replace("\"", "");
                    q.wrongAnswer2 = parts[4].replace("\"", "");
                    q.wrongAnswer3 = parts[5].replace("\"", "");
                    questions.add(q);
                }
            }
            reader.close();
            is.close();
        } catch (Exception e) {
        }
        
        return questions;
    }
}