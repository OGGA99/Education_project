package education.storage;

import education.model.Lesson;
import education.util.FileUtil;
import java.util.LinkedList;
import java.util.List;

public class LessonStorage {


    static List<Lesson> lessons = new LinkedList<>();


    public static void add(Lesson lesson) {
        lessons.add(lesson);
        FileUtil.serializeLessons(lessons);
    }


    public static void print() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
    }

    public static void initData() {
        List<Lesson> lessonList = FileUtil.deserializeLessons();
        if (lessonList != null) {
            lessons = lessonList;
        }

    }

    public Lesson getByLessonName(String lessonName) {
        for (Lesson lesson : lessons) {
            if (lesson.getLectureName().equals(lessonName)) {
                return lesson;
            }

        }
        return null;
    }

    public void deleteLessonByName(Lesson lesson) {
        lessons.remove(lesson);
        FileUtil.serializeLessons(lessons);
    }
}