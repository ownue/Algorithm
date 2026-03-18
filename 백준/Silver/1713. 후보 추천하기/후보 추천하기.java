import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 학생 정보
    static StudentInfo[] students = new StudentInfo[100];
    // 사진틀
    static ArrayList<Integer> pictures = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());

        for (int i = 0; i < 100; i++) {
            students[i] = new StudentInfo(0, 0, false);
        }

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < R; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 이미 들어있다면
            // recommendCount만 업데이트
            if (students[now - 1].isPublished) {
                students[now - 1].recommendCount++;
            }

            // 들어있지 않다면
            else {
                // 꽉 차있지 않다면
                if (pictures.size() < N) {
                    // 넣고,
                    pictures.add(now);

                    students[now - 1].recommendCount = 1;
                    students[now - 1].insertTime = i;
                    students[now - 1].isPublished = true;
                }

                // 꽉 차있다면
                else {
                    int changeIdx = pictures.get(0);
                    int recommendCount = students[changeIdx - 1].recommendCount;
                    int insertTime = students[changeIdx - 1].insertTime;

                    for (int idx : pictures) {
                        // recommendCount 비교
                        // 새로 나온 애가 더 적다면
                        if (students[idx - 1].recommendCount < recommendCount) {
                            changeIdx = idx;
                            recommendCount = students[idx - 1].recommendCount;
                            insertTime = students[idx - 1].insertTime;
                        }
                        // 같다면
                        else if (students[idx - 1].recommendCount == recommendCount) {
                            // 언제 삽입됐는지로 비교
                            if (students[idx - 1].insertTime < insertTime) {
                                changeIdx = idx;
                                recommendCount = students[idx - 1].recommendCount;
                                insertTime = students[idx - 1].insertTime;
                            }
                        }
                    }

                    pictures.remove(Integer.valueOf(changeIdx));
                    students[changeIdx - 1].isPublished = false;
                    students[changeIdx - 1].recommendCount = 0;

                    pictures.add(now);

                    students[now - 1].recommendCount = 1;
                    students[now - 1].insertTime = i;
                    students[now - 1].isPublished = true;
                }
            }
        }

        Collections.sort(pictures);
        StringBuilder sb = new StringBuilder();
        for (int k : pictures) {
            sb.append(k).append(" ");
        }

        System.out.println(sb.toString());
    }

    static class StudentInfo {
        int recommendCount;
        int insertTime;
        boolean isPublished;

        StudentInfo(int recommendCount,
                    int insertTime,
                    boolean isPublished) {
            this.recommendCount = recommendCount;
            this.insertTime = insertTime;
            this.isPublished = isPublished;
        }
    }
}