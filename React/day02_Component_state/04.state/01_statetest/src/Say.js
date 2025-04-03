// import React, { useState } from "react";

// const Say = () => {
//   const [message, setMessage] = useState("");
//   const [color, setColor] = useState("black");

//   const onClickEnter = () => {
//     setMessage("안녕하세요");
//   };

//   const onClickLeave = () => {
//     setMessage("안녕히 가세요");
//   };

//   return (
//     <div>
//       <button onClick={onClickEnter}>입장</button>
//       <button onClick={onClickLeave}>퇴장</button>
//       <h1 style={{ color }}>{message}</h1>

//       <button
//         onClick={() => {
//           setColor("red");
//         }}
//       >
//         red
//       </button>

//       <button
//         onClick={() => {
//           setColor("blue");
//         }}
//       >
//         blue
//       </button>

//       <button
//         onClick={() => {
//           setColor("green");
//         }}
//       >
//         green
//       </button>
//     </div>
//   );
// };

// export default Say;

import React, { Component } from "react";

export default class Say extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "",
      color: "black",
    };
  }
  onClickEnter = () => {
    this.setState({ message: "안녕하세요" });
  };
  onClickLeave = () => {
    this.setState({ message: "안녕히 가세요" });
  };

  setColor = (color) => {
    this.setState({ color });
  };

  render() {
    return (
      <div>
        <button onClick={this.onClickEnter}>입장</button>
        <button onClick={this.onClickLeave}>퇴장</button>
        <h1 style={{ color: this.state.color }}> {this.state.message}</h1>
        <button
          onClick={() => {
            this.setColor("red");
          }}
        >
          red
        </button>
        <button
          onClick={() => {
            this.setColor("blue");
          }}
        >
          blue
        </button>
        <button
          onClick={() => {
            this.setColor("green");
          }}
        >
          green
        </button>
      </div>
    );
  }
}
