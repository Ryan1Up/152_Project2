package Student;

import Assessment.IAssessment;

public interface Assignee {

    void notify(IAssessment assessment);

    void submit();

    void subscribeToAssessment(IAssessment assessment);
}
