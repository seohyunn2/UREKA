import React, { Component } from "react";

export default class EventHandle extends Component {
  //바벨이 생성자 내부에 만드는 코드로 변환한다.
  state = {
    message: "",
    username: "",
  };

  handleChange = (e) => {
    this.setState({
      // JSON 객체 내부에서 key를 동적으로 변경할 때는 [key]
      [e.target.name]: e.target.value,
    });
  };
  handleClick = () => {
    this.setState({
      message: "",
      username: "",
    });
  };
  handleKeyDown = (e) => {
    if (e.key === "Enter") {
      this.handleClick();
    }
  };

  render() {
    return (
      <div>
        <input
          type="text"
          value={this.state.username}
          onKeyDown={this.handleKeyDown}
          onChange={this.handleChange}
          name="username"
          placeholder="user name"
        ></input>
        <input
          type="text"
          value={this.state.message}
          onKeyDown={this.handleKeyDown}
          onChange={this.handleChange}
          name="message"
          placeholder="message"
        ></input>
        <button type="button" onClick={this.handleClick}>
          확인
        </button>
        <div>
          {this.state.username} {this.state.username !== "" && ":"} {this.state.message}
        </div>
      </div>
    );
  }
}
