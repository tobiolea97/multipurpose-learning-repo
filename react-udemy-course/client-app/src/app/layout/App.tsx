import { useEffect, useState } from "react";
import { Activity } from "../models/activity";
import { Container} from "semantic-ui-react";
import NavBar from "./NavBar";
import ActivityDashboard from "../../features/activities/dashboard/ActivityDashboard";
import { v4 as uuid } from 'uuid';

function App() {
  const [activities, setActivities] = useState<Activity[]>([]);
  const [selectedActivity, setSelectedActivity] = useState<Activity | undefined>(undefined);
  const [editMode, setEditMode] = useState(false);


  useEffect(() => {
    const activities = [];
    let activity: Activity = {
      id: "1",
      title: "Past Activity 1",
      date: "2020-01-01",
      category: "drinks",
      description: "Activity 1",
      city: "London",
      venue: "Pub",
    };
    activities.push(activity);
    activity = {
      id: "2",
      title: "Past Activity 2",
      date: "2020-01-01",
      category: "drinks",
      description: "Activity 1",
      city: "London",
      venue: "Pub",
    };
    activities.push(activity);
    setActivities(activities);
  }, []);

  function handleSelectActivity(id: string) {
    setSelectedActivity(activities.find(x => x.id === id));
  }

  function handleCancelSelect() {
    setSelectedActivity(undefined);
  }

  function handleFormOpen(id?: string) {
    id ? handleSelectActivity(id) : handleCancelSelect();
    setEditMode(true);
  }

  function handleFormClose() {
    setEditMode(false);
  }

  function handleCreateOrEditActivity(activity: Activity) {
    activity.id
      ? setActivities([...activities.filter(x => x.id !== activity.id), activity])
      : setActivities([...activities, { ...activity, id: uuid() }]);
    setEditMode(false);
    setSelectedActivity(activity);
  }

  return (
    <>
      <NavBar openForm={handleFormOpen} />
      <Container style={{marginTop: '7em'}} >
        <ActivityDashboard
          activities={activities}
          selectedActivity={selectedActivity}
          selectActivity={handleSelectActivity}
          cancelSelectActivity={handleCancelSelect}
          editMode={editMode}
          openForm={handleFormOpen}
          closeForm={handleFormClose}
          createOrEdit={handleCreateOrEditActivity}
        />
      </Container>
    </>
  )
}

export default App
