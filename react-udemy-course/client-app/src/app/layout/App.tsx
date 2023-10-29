import { useEffect, useState } from "react";
import { Activity } from "../models/activity";
import { Header } from "semantic-ui-react";
import List from "semantic-ui-react/dist/commonjs/elements/List";

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
    const activities = [activity];
    setActivities(activities);
  }, []);

  return (
    <div>
      <Header as = 'h2' icon = 'users' content = 'Reactivities' />
      <List>
        {activities.map((activity: Activity) => (
          <List.Item key={activity.id}>
            {activity.title}
          </List.Item>
        ))}
      </List>
    </div>
  )
}

export default App
