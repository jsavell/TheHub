'use strict';

const React = require('react');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {users: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/users'}).done(response => {
			this.setState({users: response.entity._embedded.users});
		});
	}

	render() {
		return (
			<UserList users={this.state.users}/>
		)
	}
}

class UserList extends React.Component{
	render() {
		var users = this.props.users.map(user =>
			<User key={user._links.self.href} user={user}/>
		);
		return (
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				{users}
			</table>
		)
	}
}

class User extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.user.firstName}</td>
				<td>{this.props.user.lastName}</td>
			</tr>
		)
	}
}

React.render(
	<App />,
	document.getElementById('react')
)

