import { useEffect, useState } from "react";
import { Activity } from "../models/activity";
import { Header } from "semantic-ui-react";
import List from "semantic-ui-react/dist/commonjs/elements/List";
import NavBar from "./NavBar";

function App() {
  const [activities, setActivities] = useState<Activity[]>([]);

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

  return (
    <div>
      <NavBar />
      <List>
        {activities.map((activity) => (
          <List.Item key={activity.id}>
            {activity.title}
          </List.Item>
        ))}
      </List>
    </div>
  )
}

export default App
