package glassa.tacoma.uw.edu.webserviceslab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aglas on 10/24/2016.
 */

public class Course implements Serializable{
    String mCourseID, mShortDescription, mLongDescription, mPrereqs;
    public static final String ID = "id", SHORT_DESC = "shortDesc",
            LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    public Course(String mCourseID, String mShortDescription, String mLongDescription, String mPrereqs) {
        this.mCourseID = mCourseID;
        this.mShortDescription = mShortDescription;
        this.mLongDescription = mLongDescription;
        this.mPrereqs = mPrereqs;
    }

    public String getmCourseID() {
        return mCourseID;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public String getmLongDescription() {
        return mLongDescription;
    }

    public String getmPrereqs() {
        return mPrereqs;
    }

    public void setmCourseID(String mCourseID) {
        this.mCourseID = mCourseID;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public void setmLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public void setmPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }
    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }

}
