import { useEffect, useState } from "react";
import { Activity } from "../models/activity";
import { Container} from "semantic-ui-react";
import NavBar from "./NavBar";
import ActivityDashboard from "../../features/activities/dashboard/ActivityDashboard";

function App() {
  const [activities, setActivities] = useState<Activity[]>([]);
  const [selectedActivity, setSelectedActivity] = useState<Activity | undefined>(undefined);

  useEffect(() => {
    const activity: Activity = {
      id: "1",
      title: "Past Activity 1",
      date: "2020-01-01",
      category: "drinks",
      description: "Activity 1",
      city: "London",
      venue: "Pub",
    };
    const activities = [];
    activities.push(activity);
    activities.push(activity);
    activities.push(activity);
    setActivities(activities);
  }, []);

  function handleSelectActivity(id: string) {
    setSelectedActivity(activities.find(x => x.id === id));
  }

  function handleCancelSelect() {
    setSelectedActivity(undefined);
  }

  return (
    <>
      <NavBar />
      <Container style={{marginTop: '7em'}} >
        <ActivityDashboard
          activities={activities}
          selectedActivity={selectedActivity}
          selectActivity={handleSelectActivity}
          cancelSelectActivity={handleCancelSelect}
        />
      </Container>
    </>
  )
}

export default App
