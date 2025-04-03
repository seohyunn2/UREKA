import React from "react";
import UserInfo from "./UserInfo";

function Comment(props) {
  return (
    <div>
      <UserInfo author={props.author} />
      <div>{props.text}</div>
      <div>{props.date.toLocaleDateString()}</div>
    </div>
  );
}

export default Comment;
